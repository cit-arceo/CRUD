package org.uv.dao;

import org.uv.idao.IDao;

/**
 *
 * @author citla
 */
public class FactoryDAO {
    public enum Type {
        EMPLEADOS, DEPARTAMENTOS
    }
    
    public static IDao getDao(Type opcion){
        IDao dao = null;
        switch(opcion){
            case EMPLEADOS:
                dao = new DAOEmpleado();
                break;
            case DEPARTAMENTOS:
                System.out.println("No hay disponibles...");
                break;
            default:
                System.out.println("ERROR, DAO no encontrado...");
        }
        return dao;
    }
}
