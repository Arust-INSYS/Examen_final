/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.examen.examen_final.entity;

import java.io.Serializable;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 *
 * @author Arust
 */
@Getter
@Setter
@Document(collection = "carrera")
@Data
public class Carrera implements Serializable{
    private static final long serialVersionUID = 1L;
	@Id
	private Long id_carrera;
	private String nombre;
	private String descripcion;
        
        //Relaciones
        private Periodo periodo;
    
}
