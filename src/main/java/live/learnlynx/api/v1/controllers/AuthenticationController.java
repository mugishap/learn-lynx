package live.learnlynx.api.v1.controllers;

import live.learnlynx.api.v1.dtos.InitiatePasswordDTO;
import live.learnlynx.api.v1.dtos.ResetPasswordDTO;
import live.learnlynx.api.v1.dtos.SignInDTO;
import live.learnlynx.api.v1.enums.EUserStatus;
import live.learnlynx.api.v1.exceptions.AppException;
import live.learnlynx.api.v1.models.User;
import live.learnlynx.api.v1.payload.ApiResponse;
import live.learnlynx.api.v1.payload.JwtAuthenticationResponse;
import live.learnlynx.api.v1.security.JwtTokenProvider;
import live.learnlynx.api.v1.services.IUserService;
import live.learnlynx.api.v1.services.MailService;
import live.learnlynx.api.v1.utils.Utility;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/auth")
public class AuthenticationController {

    private final IUserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtTokenProvider jwtTokenProvider;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final MailService mailService;

    @PostMapping(path = "/signin")
    public ResponseEntity<ApiResponse> signin(@Valid @RequestBody SignInDTO dto) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(dto.getEmail(), dto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = null;

        try {
            jwt = jwtTokenProvider.generateToken(authentication);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(new ApiResponse(true, "Logged in successfully", new JwtAuthenticationResponse(jwt)));
    }

    @PostMapping(path = "/initiate-reset-password")
    public ResponseEntity<ApiResponse> initiateResetPassword(@RequestBody @Valid InitiatePasswordDTO dto) {
        User user = this.userService.getByEmail(dto.getEmail());
        user.setActivationCode(Utility.randomUUID(6, 0, 'N'));
        user.setStatus(EUserStatus.RESET);

        this.userService.create(user);

        mailService.sendResetPasswordMail(user.getEmail(), user.getFirstName() + " " + user.getLastName(), user.getActivationCode());

        return ResponseEntity.ok(new ApiResponse(true, "Please check your mail and activate account"));
    }


    @PostMapping(path = "/reset-password")
    public ResponseEntity<ApiResponse> resetPassword(@RequestBody @Valid ResetPasswordDTO dto) {
        User user = this.userService.getByEmail(dto.getEmail());

        if (Utility.isCodeValid(user.getActivationCode(), dto.getActivationCode()) &&
                (user.getStatus().equals(EUserStatus.RESET)) || user.getStatus().equals(EUserStatus.PENDING)) {
            user.setPassword(bCryptPasswordEncoder.encode(dto.getPassword()));
            user.setActivationCode(Utility.randomUUID(6, 0, 'N'));
            user.setStatus(EUserStatus.ACTIVE);
            this.userService.create(user);
        } else {
            throw new AppException("Invalid code or account status");
        }
        return ResponseEntity.ok(new ApiResponse(true, "Password successfully reset"));
    }
}