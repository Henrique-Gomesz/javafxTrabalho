package com.example.operacoesfx.db.dal;

import com.example.operacoesfx.db.entidades.Banco;
import com.example.operacoesfx.db.entidades.Cliente;
import com.example.operacoesfx.db.entidades.Empresa;
import com.example.operacoesfx.db.util.DBSingleton;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAL implements IDAL<Cliente> {
    @Override
    public boolean gravar(Cliente entidade) {
        String sql="insert into cliente values (default,$1,'$2',$3,'$4','$5','$6','$7','$8','$9','$10',$11)";
        sql=sql.replace("$1",""+entidade.getDocumento());
        sql=sql.replace("$2", entidade.getNome());
        sql=sql.replace("$3", ""+entidade.getCep());
        sql=sql.replace("$4", entidade.getEndereco());
        sql=sql.replace("$5", entidade.getNumero());
        sql=sql.replace("$6", entidade.getCidade());
        sql=sql.replace("$7", entidade.getUf());
        sql=sql.replace("$8", entidade.getBairro()  );
        sql=sql.replace("$9", entidade.getFone());
        sql=sql.replace("$10", entidade.getEmail());
        sql=sql.replace("$11", ""+entidade.getJuros());
        return DBSingleton.getCon().manipular(sql);

    }

    @Override
    public boolean alterar(Cliente entidade) {

        String sql = "UPDATE cliente SET " +
                "cli_documento = $1, " +
                "cli_nome = $2, " +
                "cli_cep = $3, " +
                "cli_endereco = $4, " +
                "cli_numero = $5, " +
                "cli_cidade = $6, " +
                "cli_uf = $7, " +
                "cli_bairro = $8, " +
                "cli_fone = $9, " +
                "cli_email = $10, " +
                "cli_juros = $11 " +
                "WHERE cli_id = $12";
        sql=sql.replace("$1",""+entidade.getDocumento());
        sql=sql.replace("$2", entidade.getNome());
        sql=sql.replace("$3", ""+entidade.getCep());
        sql=sql.replace("$4", entidade.getEndereco());
        sql=sql.replace("$5", entidade.getNumero());
        sql=sql.replace("$6", entidade.getCidade());
        sql=sql.replace("$7", entidade.getUf());
        sql=sql.replace("$8", entidade.getBairro());
        sql=sql.replace("$9", entidade.getFone());
        sql=sql.replace("$10", entidade.getEmail());
        sql=sql.replace("$11", ""+entidade.getJuros());
        sql=sql.replace("$12", ""+entidade.getId());
        return DBSingleton.getCon().manipular(sql);
    }

    @Override
    public boolean apagar(Cliente entidade) {
        return DBSingleton.getCon().manipular("delete from cliente where cli_id="+entidade.getId());
    }

    @Override
    public Cliente get(int id) {

        Cliente cliente = null;
        String sql="select * from cliente where cli_id="+id;
        ResultSet rs=DBSingleton.getCon().consultar(sql);
        try {
            if (rs.next()) {
                cliente = new Cliente(rs.getInt("cli_id"),rs.getString("cli_nome"),
                        rs.getLong("cli_documento"),rs.getInt("cli_cep"),
                        rs.getString("cli_endereco"),rs.getString("cli_numero"),
                        rs.getString("cli_cidade"),rs.getString("cli_uf"),
                        rs.getString("cli_bairro"),rs.getString("cli_fone"),
                        rs.getString("cli_email"),rs.getDouble("cli_juros"));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return cliente;
    }

    @Override
    public List<Cliente> get(String filtro) {
        List<Cliente> clientes = new ArrayList<>();
        String sql="select * from cliente";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        sql+=" order by cli_nome";
        ResultSet rs= DBSingleton.getCon().consultar(sql);
        try {
            while (rs.next()) {
                clientes.add(new Cliente(rs.getInt("cli_id"),rs.getString("cli_nome"),
                                         rs.getLong("cli_documento"),rs.getInt("cli_cep"),
                                         rs.getString("cli_endereco"),rs.getString("cli_numero"),
                                         rs.getString("cli_cidade"),rs.getString("cli_uf"),
                                         rs.getString("cli_bairro"),rs.getString("cli_fone"),
                                         rs.getString("cli_email"),rs.getDouble("cli_juros")));
            }
        }catch(Exception e){
            System.out.println(e);
        }
        return clientes;
    }
}
