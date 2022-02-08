package org.uv.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.uv.idao.IDao;
import org.uv.models.Departamentos;
import org.uv.utils.ConexionDB;

/**
 *
 * @author citla
 */
public class DAODepartamento implements IDao <Departamentos>{
    private String sql = "";
    private ConexionDB con = ConexionDB.getInstance();
    private Departamentos departamentos = new Departamentos();
    private List<Departamentos> lista = new ArrayList();

    @Override
    public boolean insertRecord(Departamentos t) {
        sql = "INSERT INTO departamentos VALUES (" + t.getClave() + ",'" + t.getNombre() + "');";
        return con.execute(sql);
    }

    @Override
    public boolean deleteRecord(long clave) {
        sql = "DELETE FROM departamentos WHERE (clave = " + clave +");";
        return con.execute(sql);
    }

    @Override
    public boolean updateRecord(Departamentos pojo) {
        sql = "UPDATE departamentos SET nombre = '" + pojo.getNombre() + "' WHERE (clave = " + pojo + ");"; 
        return con.execute(sql);
    }

    @Override
    public Departamentos readOneRecord(long clave) {
        sql = "SELECT * FROM departamentos WHERE (clave = " + clave + ");";
        ResultSet data = con.getData(sql);
        try {
            if(data.next()){
                departamentos.setClave(data.getLong("clave"));
                departamentos.setNombre(data.getString("nombre"));
            }else{
                System.out.println("No hay registros disponibles...");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAODepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return departamentos;
    }

    @Override
    public List<Departamentos> readRecords() {
        try {
            sql = "SELECT * FROM departamentos;";
            ResultSet data = con.getData(sql);
            while(data.next()){
                lista.add(new Departamentos(data.getLong(1),
                        data.getString(2)));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAODepartamento.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lista;
    }
}
