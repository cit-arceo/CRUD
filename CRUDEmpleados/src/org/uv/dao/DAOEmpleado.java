package org.uv.dao;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.uv.idao.IDao;
import org.uv.models.Empleados;
import org.uv.utils.ConexionDB;

/**
 *
 * @author citla
 */
public class DAOEmpleado implements IDao <Empleados>{
    private String sql = "";
    private ConexionDB con = ConexionDB.getInstance();
    private Empleados empleados = new Empleados();
    private List<Empleados> lista = new ArrayList();
    
    
    @Override
    public boolean insertRecord(Empleados t) {  
        sql = "INSERT INTO empleados VALUES (" + t.getClave() + ",'" + t.getNombre() + "','" + t.getDireccion() + "','"
                + t.getTelefono() + "');";
        return con.execute(sql);
    }

    @Override
    public boolean deleteRecord(long clave) {
        sql = "DELETE FROM empleados WHERE (clave = " + clave +");";
        return con.execute(sql);
    }

    @Override
    public boolean updateRecord(Empleados  pojo) {
        sql = "UPDATE empleados SET nombre = '" + pojo.getNombre() + "', direccion = '" + pojo.getDireccion() + 
                    "', telefono = '" + pojo.getTelefono() + "' WHERE (clave = " + pojo + ");"; 
        return con.execute(sql);
    }

    @Override
    public Empleados readOneRecord(long clave) {
        sql = "SELECT * FROM empleados WHERE (clave = " + clave + ");";
        ResultSet data = con.getData(sql);
        try {
            if(data.next()){
                empleados.setClave(data.getLong("clave"));
                empleados.setNombre(data.getString("nombre"));
                empleados.setDireccion(data.getString("direccion"));
                empleados.setTelefono(data.getString("telefono"));
            }else{
                System.out.println("No hay registros disponibles...");
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return empleados;
    }

    @Override
    public List<Empleados> readRecords() {
        try {
            sql = "SELECT * FROM empleados;";
            ResultSet data = con.getData(sql);
            while(data.next()){
                lista.add(new Empleados(data.getLong(1),
                        data.getString(2), 
                        data.getString(3),
                        data.getString(4)));
            }
        } catch (SQLException ex) {
            java.util.logging.Logger.getLogger(DAOEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        return lista;
    }
}