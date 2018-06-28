package com.szalaynb.NudgeYourMind.service;

import com.szalaynb.NudgeYourMind.model.Link;
import com.szalaynb.NudgeYourMind.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Service;

import java.util.List;

@RepositoryRestResource
@Service
public class LinkService {

    private final LinkRepository linkRepository;

    @Autowired
    public LinkService(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    public List<Link> findAll() {
        return linkRepository.findAll();
    }

    public Link findById(Long id) {
        return linkRepository.findById(id).get();
    }

    public void savelink(Link link) {
        linkRepository.save(link);
    }

    public void deletelink(Long id) {
        linkRepository.deleteById(id);
    }


}
