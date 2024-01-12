package com.example.demo.repository;

import com.example.demo.entity.Clan;
import com.example.demo.entity.ComponentaClan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ComponentaClanRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<ComponentaClan> findAllComponentaClan(){
        return jdbcTemplate.query("SELECT * FROM ComponentaClan", (resultSet, rowNum) -> {
            ComponentaClan componentaClan = new ComponentaClan();

            componentaClan.setClanUI(resultSet.getString("clanUI"));
            componentaClan.setNumeClan(resultSet.getString("numeClan"));
            componentaClan.setMembru1(resultSet.getString("membru1"));
            componentaClan.setMembru2(resultSet.getString("membru2"));
            componentaClan.setMembru3(resultSet.getString("membru3"));
            componentaClan.setMembru4(resultSet.getString("membru4"));
            componentaClan.setMembru5(resultSet.getString("membru5"));
            componentaClan.setMembru6(resultSet.getString("membru6"));
            componentaClan.setMembru7(resultSet.getString("membru7"));
            componentaClan.setMembru8(resultSet.getString("membru8"));
            componentaClan.setMembru9(resultSet.getString("membru9"));
            componentaClan.setMembru10(resultSet.getString("membru10"));
            return componentaClan;
        });
    }

    public void create(ComponentaClan componentaClan){

        String sql = "insert into ComponentaClan(clanUI, numeClan, membru1, membru2, membru3, membru4, membru5, " +
        "membru6, membru7, membru8, membru9, membru10) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, componentaClan.getClanUI(), componentaClan.getNumeClan(), componentaClan.getMembru1(), componentaClan.getMembru2(), componentaClan.getMembru3(),
                componentaClan.getMembru4(), componentaClan.getMembru5(), componentaClan.getMembru6(), componentaClan.getMembru7(),
                componentaClan.getMembru8(), componentaClan.getMembru9(), componentaClan.getMembru10()
        );
    }

    public void update(ComponentaClan componentaClan, String clanUI){
        String sql = "update ComponentaClan set numeClan = ?, membru1 = ?, membru2 = ?, membru3 = ?, membru4 = ?, membru5 = ?," +
                "membru6 = ?, membru7 = ?, membru8 = ?, membru9 = ?, membru10 = ? where clanUI = ?";

        jdbcTemplate.update(sql, componentaClan.getNumeClan(), componentaClan.getMembru1(), componentaClan.getMembru2(),
                componentaClan.getMembru3(), componentaClan.getMembru4(), componentaClan.getMembru5(), componentaClan.getMembru6(),
                componentaClan.getMembru7(), componentaClan.getMembru8(), componentaClan.getMembru9(), componentaClan.getMembru10(),
                clanUI
                );
    }

    public void delete(String clanUI){
        String sql = "delete from ComponentaClan where clanUI = ?";

        jdbcTemplate.update(sql, clanUI);
    }

}
