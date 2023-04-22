package ru.tinkoff.edu.java.scrapper.repository.jdbc;

import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import ru.tinkoff.edu.java.scrapper.mapper.LinkRowMapper;
import ru.tinkoff.edu.java.scrapper.model.Link;
import ru.tinkoff.edu.java.scrapper.repository.LinkRepository;

import java.sql.Timestamp;
import java.util.List;


@Slf4j
public class LinkJdbcTemplateRepository implements LinkRepository {


    private final JdbcTemplate jdbcTemplate;

    private final LinkRowMapper linkRowMapper;

    public LinkJdbcTemplateRepository(JdbcTemplate jdbcTemplate, LinkRowMapper linkRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.linkRowMapper = linkRowMapper;
    }


    @Override
    public List<Link> findAll() {
        log.info("findAll() method invocation in linkRepo");
        String sql = "select * from link";
        return jdbcTemplate.query(sql, linkRowMapper);
    }

    @Override
    public Link findByUrl(String url) {
        log.info("findByUrl() method invocation in linkRepo");
        String sql = "select * from link where link.url = ?";
        List<Link> link = jdbcTemplate.query(sql, linkRowMapper, url);
        return link.size() == 0 ? null : link.get(0);
    }

    @Override
    public void add(Link link) {
        log.info("add() method invocation in linkRepo");
        String sql = "insert into link (url, checked_at) values(?, ?)";
        jdbcTemplate.update(sql, link.getUrl(), link.getCheckedAt());
    }


    @Override
    public void updateCheckDate(Link link) {
        log.info("updateDate() method invocation in linkRepo");
        String sql = "update link set checked_at = ? where id = ?";
        jdbcTemplate.update(sql, link.getCheckedAt(), link.getId());
    }

    @Override
    public void remove(Long id) {
        log.info("remove() method invocation in linkRepo");
        String sql = "delete from link where link.id = ?";
        jdbcTemplate.update(sql, id);
    }

    @Override
    //поиск ссылок по критерию
    public List<Link> findOldLinks(Long timeUpdateDelta) {
        log.info("findOldLinks() method invocation in linkRepo");
        Timestamp compareDate = new Timestamp(System.currentTimeMillis() - timeUpdateDelta*1000);
        String sql = "select * from link where link.checked_at < ? order by link.checked_at desc";
        return jdbcTemplate.query(sql,linkRowMapper,compareDate);
    }

    @Override
    public void updateGhForksCount(Link link) {
        log.info("updateGhForksCount() method invocation in linkRepo");
        String sql = "update link set gh_forks_count = ? where id = ?";
        jdbcTemplate.update(sql, link.getGhForksCount(), link.getId());
    }

    @Override
    public void updateGhDescription(Link link) {
        log.info("updateGhDescription() method invocation in linkRepo");
        String sql = "update link set gh_description = ? where id = ?";
        jdbcTemplate.update(sql, link.getGhDescription(), link.getId());
    }

    @Override
    public void updateGhPushedAt(Link link) {
        log.info("updateGhPushedAt() method invocation in linkRepo");
        String sql = "update link set gh_pushed_at = ? where id = ?";
        jdbcTemplate.update(sql, link.getGhPushedAt(), link.getId());
    }

    @Override
    public void updateSoLastEditDate(Link link) {
        log.info("updateSoLastEditDate() method invocation in linkRepo");
        String sql = "update link set so_last_edit_date = ? where id = ?";
        jdbcTemplate.update(sql, link.getSoLastEditDate(), link.getId());
    }

    @Override
    public void updateSoAnswerCount(Link link) {
        log.info("updateSoAnswerCount() method invocation in linkRepo");
        String sql = "update link set so_answer_count = ? where id = ?";
        jdbcTemplate.update(sql, link.getSoAnswerCount(), link.getId());
    }
}