package com.example.operacoesfx;

import com.example.operacoesfx.db.dal.BancoDAL;
import com.example.operacoesfx.db.entidades.Banco;
import com.example.operacoesfx.db.util.Conexao;
import com.example.operacoesfx.db.util.DBSingleton;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        if(!DBSingleton.conectar())
        {
            System.out.println("Erro ao conectar "+DBSingleton.getCon().getMensagemErro());
            System.exit(0);
        }


        BancoDAL dal=new BancoDAL();
        Banco banco=dal.get(2);
        banco.setNome("Bradesco SA");
        dal.alterar(banco);
        List<Banco> bancos = dal.get("");
        for(Banco b : bancos)
            System.out.println(b.getNome());

//        Banco banco = new Banco(0,341,"Itau SA");
//        if(!dal.gravar(banco))
//            System.out.println("Erro ao salvar o banco na base de dados");


        /*---------------------------------------------------------------*/
        // Exemplo usando a classe Conexao
//        Conexao con = new Conexao();
//        if(!con.conectar("jdbc:postgresql://localhost:5432/","operacoes","postgres","postgres123"))
//        {
//            System.out.println("Erro ao conectar o banco "+con.getMensagemErro());
//            System.exit(0);
//        }
//        String sql="insert into banco values (default,1,'Banco do Brasil')";
//        String sql="select * from banco order by bco_nome";
//        if(!con.manipular(sql))  //insert, delete, update
//            System.out.println("Erro ao inserir: "+con.getMensagemErro());
//        ResultSet rs=con.consultar(sql);
//        try {
//            while (rs.next()) {
//                System.out.println(rs.getString("bco_nome"));
//            }
//        }catch(Exception e){}
/*---------------------------------------------------------------*/
        //exemplo utilizando as classes Connection, Statement e ResultSet
//        String url="jdbc:postgresql://localhost:5433/operacoes";
//        Connection connection;
//        try {
//            connection = DriverManager.getConnection(url, "postgres", "postgres123");
//            Statement statement = connection.createStatement();
//            //String sql="insert into banco values (default,237,'Bradesco')";
//            //String sql="insert into banco (bco_numero,bco_nome) values (033,'Santander')";
//            //if(statement.executeUpdate(sql)>0)
//             //   System.out.println("Operação realizada com sucesso");
//            String sql="select * from banco";
//            ResultSet rs=statement.executeQuery(sql);
//            while(rs.next())
//            {
//                System.out.println(rs.getInt("bco_numero")+" "+rs.getString("bco_nome"));
//            }
//            connection.close();
//        }catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
    }
}
