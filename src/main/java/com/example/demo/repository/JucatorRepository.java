package com.example.demo.repository;

import com.example.demo.entity.Jucator;
import com.example.demo.service.JucatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class JucatorRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    Jucator jucator = new Jucator();

    public List<Jucator> findAllJucatori() {
        return jdbcTemplate.query("SELECT * FROM Jucatori", (resultSet, rowNum) -> {
            Jucator jucator = new Jucator();
            jucator.setJucatorUI(resultSet.getString("JucatorUI"));
            jucator.setClanUI(resultSet.getString("ClanUI"));
            jucator.setNumeUtilizator(resultSet.getString("NumeUtilizator"));
            jucator.setEmail(resultSet.getString("Email"));
            jucator.setNivel(resultSet.getInt("Nivel"));
            jucator.setPuncteExperienta(resultSet.getInt("PuncteExperienta"));
            jucator.setInventar(resultSet.getString("Inventar"));
            jucator.setMonedaVirtuala(resultSet.getDouble("MonedaVirtuala"));
            jucator.setScoruri(resultSet.getString("Scoruri"));
            jucator.setIstoricChat(resultSet.getString("IstoricChat"));
            jucator.setIstoricTranzactii(resultSet.getString("IstoricTranzactii"));
            jucator.setIstoricJoc(resultSet.getString("Istoricjoc"));
            jucator.setFeedback(resultSet.getString("Feedback"));
            return jucator;
        });
    }

    public List<Jucator> cautareJucatori(String jucatorUi) {
        String sql = "select * from Jucatori where JucatorUI = ?";

        return jdbcTemplate.query(sql, new Object[]{jucatorUi}, (resultSet, rowNum) ->
                new Jucator(
                        resultSet.getString("JucatorUI"),
                        resultSet.getString("ClanUI"),
                        resultSet.getString("NumeUtilizator"),
                        resultSet.getString("Email"),
                        resultSet.getInt("Nivel"),
                        resultSet.getInt("PuncteExperienta"),
                        resultSet.getString("Inventar"),
                        resultSet.getDouble("MonedaVirtuala"),
                        resultSet.getString("Scoruri"),
                        resultSet.getString("IstoricChat"),
                        resultSet.getString("IstoricTranzactii"),
                        resultSet.getString("Istoricjoc"),
                        resultSet.getString("Feedback")
                )
        );
    }

    public boolean existByUI(String jucatorUI) {
        String sql = "SELECT count(*) FROM Jucatori where JucatorUI = ?";
        boolean ok = jdbcTemplate.queryForObject(sql, boolean.class, jucatorUI);
        return ok;
    }


    public void create(Jucator jucator, String jucatorUI) {

        String sql = "insert into Jucatori(JucatorUI, ClanUI, NumeUtilizator, Email, Nivel, PuncteExperienta, " +
                "Inventar, MonedaVirtuala, Scoruri, IstoricChat, IstoricTranzactii, IstoricJoc, Feedback) " +
                "values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        jdbcTemplate.update(sql, jucatorUI, jucator.getClanUI(), jucator.getNumeUtilizator(),
                                jucator.getEmail(), jucator.getNivel(), jucator.getPuncteExperienta(), jucator.getInventar(),
                                jucator.getMonedaVirtuala(), jucator.getScoruri(), jucator.getIstoricChat(), jucator.getIstoricTranzactii(),
                                jucator.getIstoricChat(), jucator.getFeedback()
        );
    }

    public static String randomUI() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(9);

        for (int i = 0; i < 9; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        return "#" + sb.toString();
    }

    public boolean existUI(String jucatorUI) {
        String sql = "SELECT count(*) FROM Jucatori where JucatorUI = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, jucatorUI);
        return count > 0;
    }

    public boolean existByNickname(String nickname) {
        String sql = "SELECT count(*) FROM Jucatori where NumeUtilizator = ?";
        boolean ok = jdbcTemplate.queryForObject(sql, boolean.class, nickname);
        return ok;
    }

    public void update(String jucatorUI, Jucator jucator) {
        String sql = "UPDATE Jucatori SET ClanUI = ?, NumeUtilizator = ?, Email = ?, Nivel = ?, PuncteExperienta = ?," +
                "Inventar = ?, MonedaVirtuala = ?, Scoruri = ?, IstoricChat = ?, IstoricTranzactii = ?," +
                "IstoricJoc = ?, Feedback = ? WHERE JucatorUI = ?";
        jdbcTemplate.update(
                sql,
                jucator.getClanUI(),
                jucator.getNumeUtilizator(),
                jucator.getEmail(),
                jucator.getNivel(),
                jucator.getPuncteExperienta(),
                jucator.getInventar(),
                jucator.getMonedaVirtuala(),
                jucator.getScoruri(),
                jucator.getIstoricChat(),
                jucator.getIstoricTranzactii(),
                jucator.getIstoricJoc(),
                jucator.getFeedback(),
                jucatorUI
        );
    }

    public void updateNickname(Jucator jucator, String JucatorUI, String numeNou) {
        jdbcTemplate.update(
                "update Jucatori set NumeUtilizator = ? where JucatorUI = ?",
                numeNou, JucatorUI);
    }

    public void delete(String JucatorUI){
        jdbcTemplate.update(
                "delete from Jucatori where JucatorUI = ?", JucatorUI
        );
    }

}
