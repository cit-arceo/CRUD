package org.uv.dao;

import java.util.List;
import org.uv.idao.IDao;
import org.uv.models.Departamentos;
import org.uv.models.Empleados;

/**
 *
 * @author citla
 */
public class Crud {
    public static void main(String args[]) {
        
        //MVC modelo vista controlador ---
        
//        IDao dao = FactoryDAO.getDao(FactoryDAO.Type.EMPLEADOS);
        IDao dao = FactoryDAO.getDao(FactoryDAO.Type.DEPARTAMENTOS);
        
        DAOEmpleado daoEmpleado = new DAOEmpleado();
        DAODepartamento daoDepartamento = new DAODepartamento();
        
        Empleados empleado;
        List <Empleados> lista;
//        Departamentos departamento = new Departamentos();
        
        empleado = daoEmpleado.readOneRecord(1);
        lista = daoEmpleado.readRecords();

//        empleado.setClave(1);
//        empleado.setNombre("Citlalli");
//        empleado.setDireccion("Cordoba");
//        empleado.setTelefono("12345");
//        departamento.setClave(0);
//        departamento.setNombre("Contabilidad");
        
//        System.out.println(daoEmpleado.insertRecord(empleado));
//        System.out.println(daoDepartamento.insertRecord(departamento));
//        System.out.println(daoEmpleado.readOneRecord(1));  

        for(int i = 0; i< lista.size(); i++){
            System.out.println(lista.get(i).getClave());
        }
    
//        System.out.println(empleado.getClave());
    }
}
