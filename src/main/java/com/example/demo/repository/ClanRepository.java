package com.example.demo.repository;

import com.example.demo.entity.Clan;
import com.example.demo.entity.ComponentaClan;
import com.example.demo.entity.Jucator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Random;

@Repository
public class ClanRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Clan> findAllClanuri() {
        return jdbcTemplate.query("SELECT * FROM Clan", (resultSet, rowNum) -> {
            Clan clan = new Clan();

            clan.setClanUI(resultSet.getString("ClanUI"));
            clan.setNumeClan(resultSet.getString("NumeClan"));
            clan.setNrMembri(resultSet.getString("NrMembri"));
            clan.setWelcome(resultSet.getString("Welcome"));
            return clan;
        });
    }

    public void create (Clan clan, String clanUI){

        String sql = "insert into Clan(ClanUI, NumeClan, NrMembri, Welcome) " +
                "values (?, ?, ?, ?)";

        jdbcTemplate.update(sql, clanUI, clan.getNumeClan(), clan.getNrMembri(), clan.getWelcome());
    }

    //Creez un ui nou, care este unic in baza de date
    public static String randomUI() {
        String characters = "0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder(3);

        for (int i = 0; i < 3; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }

        return "#CLN" + sb.toString();
    }

    //aici deam il verific daca este sau nu
    public boolean existUI(String clanUI) {
        String sql = "SELECT count(*) FROM Clan where ClanUI = ?";
        int count = jdbcTemplate.queryForObject(sql, Integer.class, clanUI);
        return count > 0;
    }

    public void update(String clanUI, Clan clan) {
        String sql = "UPDATE Clan SET NumeClan = ?, NrMembri = ?, Welcome = ? WHERE ClanUI = ?";
        jdbcTemplate.update(
                sql,
                clan.getNumeClan(),
                clan.getNrMembri(),
                clan.getWelcome(),
                clanUI
        );
    }

    public void delete(String ClanUI){
        jdbcTemplate.update(
                "delete from Clan where ClanUI = ?", ClanUI
        );
    }

}
