package com.java.main.springstarter.v1.serviceImpls;

import com.java.main.springstarter.v1.exceptions.ResourceNotFoundException;
import com.java.main.springstarter.v1.models.Tag;
import com.java.main.springstarter.v1.repositories.ITagRepository;
import com.java.main.springstarter.v1.services.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements ITagService {

    private final ITagRepository tagRepository;

    @Override
    public Tag getTagById(UUID id) {
        return this.tagRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Tag","id",id));
    }

    @Override
    public Tag createTag(String tagName) {
        Tag tag = new Tag(tagName);
        return this.tagRepository.save(tag);
    }

    @Override
    public Tag updateTag(String tagName, UUID tagId) {
        Tag tag = this.tagRepository.findById(tagId).orElseThrow(()->new ResourceNotFoundException("Tag","id",tagId));
        tag.setTagName(tagName);
        return this.tagRepository.save(tag);
    }

    @Override
    public String deleteTag(UUID tagId) {
        this.tagRepository.deleteById(tagId);
        return "Tag deleted successfully";
    }
}
