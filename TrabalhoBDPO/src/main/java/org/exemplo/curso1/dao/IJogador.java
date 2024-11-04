package org.exemplo.curso1.dao;

import org.exemplo.curso1.model.Jogador;
import java.sql.SQLException;

public interface IJogador{
    public void inserirBD(Jogador jogador) throws SQLException;
}