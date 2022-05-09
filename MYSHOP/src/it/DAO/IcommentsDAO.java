package it.DAO;

import it.model.article;

import java.util.ArrayList;

public interface IcommentsDAO {
    //cerca utenti da id
    ArrayList<article.comments> findById_article(int id);
}
