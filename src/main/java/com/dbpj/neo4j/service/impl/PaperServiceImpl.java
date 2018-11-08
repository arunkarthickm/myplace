package com.dbpj.neo4j.service.impl;

import com.dbpj.neo4j.node.Paper;
import com.dbpj.neo4j.repository.PaperRepository;
import com.dbpj.neo4j.service.PaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Jeremy
 * @Date: 2018/11/3 15:06
 */
@Service
public class PaperServiceImpl implements PaperService{
    @Autowired
    private PaperRepository paperRepository;

    @Override
    public Paper findById(Long id) {
        return paperRepository.findOne(id);
    }

    @Override
    public List<Paper> findAll() {
        return paperRepository.getPaperList();
    }

    @Override
    public List<Paper> findAllByTitle(String name) {
        return paperRepository.findAllByPTitleContains(name);
    }

    @Override
    public List<Paper> findAllByYear(Integer year) {
        return paperRepository.findAllByPYear(year);
    }

    @Override
    public List<Paper> findAllByYearBefore(Integer year) {
        return paperRepository.findAllByPYearBefore(year);
    }

    @Override
    public List<Paper> findAllByYearAfter(Integer year) {
        return paperRepository.findAllByPYearAfter(year);
    }

    @Override
    public List<Paper> findAllByYearBetween(Integer year1, Integer year2) {
        return paperRepository.findAllByPYearBetween(year1, year2);
    }

    @Override
    public List<Paper> save(Paper paper) {
        return paperRepository.addPaper(paper.getPTitle(), paper.getPAbstract(),
                paper.getPPage(), paper.getPCitation(), paper.getPYear());
    }

    @Override
    public List<Paper> update(Paper paper){
        return paperRepository.editPaper(paper.getId(), paper.getPTitle(), paper.getPAbstract(),
                paper.getPPage(), paper.getPCitation(), paper.getPYear());
    }

    @Override
    public void delete(Paper paper){
        paperRepository.delete(paper.getId());
    }

    @Override
    public void deletePapers(List<Paper> papers){
        List<Long> list = new ArrayList<Long>();
        for (Paper paper : papers){
            list.add(paper.getId());
        }
        paperRepository.deletePaperIn(list);
    }
}