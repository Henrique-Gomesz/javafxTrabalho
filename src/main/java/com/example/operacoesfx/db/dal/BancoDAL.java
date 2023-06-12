package com.example.operacoesfx.db.dal;

import com.example.operacoesfx.db.entidades.Banco;
import com.example.operacoesfx.db.util.Conexao;
import com.example.operacoesfx.db.util.DBSingleton;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BancoDAL implements IDAL<Banco>{
    @Override
    public boolean gravar(Banco entidade) {
        String sql="insert into banco values (default,$1,'$2')";
        sql=sql.replace("$1",""+entidade.getNumero());
        sql=sql.replace("$2", entidade.getNome());
        return DBSingleton.getCon().manipular(sql);
    }

    @Override
    public boolean alterar(Banco entidade) {
        String sql="update banco set bco_numero = $1, bco_nome='$2' where bco_id=$3";
        sql=sql.replace("$1",""+entidade.getNumero());
        sql=sql.replace("$2", entidade.getNome());
        sql=sql.replace("$3", ""+entidade.getId());
        return DBSingleton.getCon().manipular(sql);
    }

    @Override
    public boolean apagar(Banco entidade) {
        return DBSingleton.getCon().manipular("delete from banco where bco_id="+entidade.getId());
    }

    @Override
    public Banco get(int id) {
        Banco banco = null;
        String sql="select * from banco where bco_id="+id;
        ResultSet rs=DBSingleton.getCon().consultar(sql);
        try {
            if (rs.next()) {
                banco = new Banco(rs.getInt("bco_id"),
                        rs.getInt("bco_numero"),
                        rs.getString("bco_nome"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return banco;
    }

    @Override
    public List<Banco> get(String filtro) {
        List<Banco> bancos = new ArrayList<>();
        String sql="select * from banco";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        ResultSet rs=DBSingleton.getCon().consultar(sql);
        try {
            while (rs.next()) {
                bancos.add(new Banco(rs.getInt("bco_id"),
                        rs.getInt("bco_numero"),
                        rs.getString("bco_nome")));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return bancos;
    }
}
