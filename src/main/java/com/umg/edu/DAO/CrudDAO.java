package com.umg.edu.DAO;

public interface CrudDAO<T> {
    boolean insertar (T objeto);
    boolean actualizar (T objeto);
    boolean eliminar (int id);
    T buscarPorID(id);
    List<T> listarTodos();
}