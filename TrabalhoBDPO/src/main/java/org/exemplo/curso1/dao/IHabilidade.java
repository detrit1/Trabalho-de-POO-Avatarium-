package org.exemplo.curso1.dao;

import org.exemplo.curso1.model.Habilidades;
import org.exemplo.curso1.model.Jogador;
import java.sql.SQLException;

public interface IHabilidade{
    public void inserirHB(Habilidades habilidades) throws SQLException;
}