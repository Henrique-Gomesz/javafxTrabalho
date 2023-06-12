package com.example.operacoesfx.db.dal;

import com.example.operacoesfx.db.entidades.Cheque;
import com.example.operacoesfx.db.entidades.Operacao;
import com.example.operacoesfx.db.util.DBSingleton;

import java.util.List;

public class OperacaoDAL implements IDAL<Operacao>{
    @Override
    public boolean gravar(Operacao operacao) {
        String sql="INSERT INTO public.operacao(op_data, op_juros, 'op_valor-liquido', cli_id) VALUES ('#2', #3, #4, #5)";
        sql=sql.replace("#2",operacao.getData().toString());
        sql=sql.replace("#3",""+operacao.getJuros());
        sql=sql.replace("#4",""+operacao.getValorliq());
        sql=sql.replace("#5",""+operacao.getCliente().getId());
        System.out.println(sql);
        if(DBSingleton.getCon().manipular(sql))
        {   int codOp=DBSingleton.getCon().getMaxPK("operacao","op_id");
            sql="INSERT INTO public.cheque(che_agencia, che_conta, che_documento, che_correntista, che_valor, che_data, bco_id, op_id) VALUES (#1, #2, #3, '#4', #5, '#6', #7, #8)";
            for (Cheque c : operacao.getCheques())
            {
                sql=sql.replace("#1",""+c.getAgencia());
                sql=sql.replace("#2",""+c.getConta());
                sql=sql.replace("#3",""+c.getDocumento());
                sql=sql.replace("#4",c.getCorrentista());
                sql=sql.replace("#5",""+c.getValor());
                sql=sql.replace("#6",""+c.getData());
                sql=sql.replace("#7",""+c.getBanco().getId());
                sql=sql.replace("#8",""+codOp);
                System.out.println(sql);
                DBSingleton.getCon().manipular(sql);
            }
        }
        return true;
    }

    @Override
    public boolean alterar(Operacao entidade) {


    }

    @Override
    public boolean apagar(Operacao entidade) {
        return DBSingleton.getCon().manipular("delete from operacao where cli_id="+entidade.getId());
    }

    @Override
    public Operacao get(int id) {
        return null;
    }

    @Override
    public List<Operacao> get(String filtro) {
        return null;
    }
}
