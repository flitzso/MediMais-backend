package com.medi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "consultas")
@Data
public class Consultas {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Integer paciente_id;
    private Integer medico_id;
    private Integer data_consulta;
    private String descricao;
    private String status;
    private String cidade_paciente;
    private String estado_paciente;

    public Integer getPaciente_id() {
        return paciente_id;
    }

    public void setPaciente_id(Integer paciente_id) {
        this.paciente_id = paciente_id;
    }

    public Integer getMedico_id() {
        return medico_id;
    }

    public void setMedico_id(Integer medico_id) {
        this.medico_id = medico_id;
    }

    public Integer getData_consulta() {
        return data_consulta;
    }

    public void setData_consulta(Integer data_consulta) {
        this.data_consulta = data_consulta;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCidade_paciente() {
        return cidade_paciente;
    }

    public void setCidade_paciente(String cidade_paciente) {
        this.cidade_paciente = cidade_paciente;
    }

    public String getEstado_paciente() {
        return estado_paciente;
    }

    public void setEstado_paciente(String estado_paciente) {
        this.estado_paciente = estado_paciente;
    }
}
