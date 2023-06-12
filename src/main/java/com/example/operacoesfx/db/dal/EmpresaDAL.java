package com.example.operacoesfx.db.dal;

import com.example.operacoesfx.db.entidades.Empresa;
import com.example.operacoesfx.db.util.DBSingleton;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpresaDAL implements IDAL<Empresa> {

    @Override
    public boolean gravar(Empresa entidade) {
        String sql="insert into empresa values (default,$1,'$2')";
        sql=sql.replace("$1",""+entidade.getRazao());
        sql=sql.replace("$2", entidade.getNomeFantasia());
        return DBSingleton.getCon().manipular(sql);
    }

    @Override
    public boolean alterar(Empresa entidade) {
        String sql="update empresa set emp_razao = $1, emp_fantasia='$2' where emp_id=$3";
        sql=sql.replace("$1",""+entidade.getRazao());
        sql=sql.replace("$2", entidade.getNomeFantasia());
        sql=sql.replace("$3", ""+entidade.getId());
        return DBSingleton.getCon().manipular(sql);
    }

    @Override
    public boolean apagar(Empresa entidade) {
        return DBSingleton.getCon().manipular("delete from empresa where emp_id="+entidade.getId());
    }

    @Override
    public Empresa get(int id) {
        Empresa empresa = null;
        String sql="select * from empresa where emp_id="+id;
        ResultSet rs=DBSingleton.getCon().consultar(sql);
        try {
            if (rs.next()) {
                empresa = new Empresa(rs.getInt("emp_id"),
                        rs.getString("emp_razao"),
                        rs.getString("emp_fantasia"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return empresa;
    }

    @Override
    public List<Empresa> get(String filtro) {
        List<Empresa> empresas = new ArrayList<>();
        String sql="select * from empresa";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by emp_id";
        ResultSet rs= DBSingleton.getCon().consultar(sql);
        try {
            while (rs.next()) {
                empresas.add(new Empresa(rs.getInt("emp_id"), rs.getString("emp_razao"), rs.getString("emp_fantasia")));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return empresas;
    }
}
