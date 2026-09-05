package com.umg.edu.DAO;

import java.util.List;

public interface CrudDAO<T> {
    boolean insertar (T objeto);
    boolean actualizar (T objeto);
    boolean eliminar (int id);
    T buscarPorID(int id);
    List<T> listarTodos();
}