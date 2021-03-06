package com.dbpj.neo4j.service;

import com.dbpj.neo4j.node.Conference;

import java.util.List;

/**
 * @Author: Jeremy
 * @Date: 2018/11/3 20:24
 */
public interface ConferenceService {
    /**
     * 根据id查询
     */
    Conference findById(Long id);

    /**
     * 返回所有
     * @return
     */
    List<Conference> findAll();

    /**
     * 根据名称查询
     * @param fName
     * @return
     */
    List<Conference> findByCName(String fName);

    /**
     * 根据名称查询
     * @param fName
     * @return
     */
    List<Conference> findAllByCName(String fName);

    /**
     * 添加
     * @return
     */
    List<Conference> save(Conference conference);


    /**
     * 保存列表
     */
    List<Long> save(List<Conference> conferenceList);

    /**
     * 更新
     * @return
     */
    List<Conference> update(Conference conference);

    /**
     * 删除单节点
     * @param conference
     */
    void delete(Conference conference);

    /**
     * 批量删除
     * @param conferences
     */
    void deleteConferences(List<Conference> conferences);
}
