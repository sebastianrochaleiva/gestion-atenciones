# 🏥 Sistema de Gestión de Atenciones Médicas

Este proyecto es una **prueba técnica** desarrollada con **Spring Boot** que simula un sistema de gestión de atenciones médicas.  
Se implementa siguiendo el patrón **MVC**, con seguridad mediante **JWT y roles (ADMIN, PACIENTE, MEDICO)**.  

---
# 🏥 Sistema de Gestión de Atenciones Médicas

Este proyecto es una **prueba técnica** desarrollada con **Spring Boot** que simula un sistema de gestión de atenciones médicas.  
Se implementa siguiendo el patrón **MVC**, con seguridad mediante **JWT y roles (ADMIN, PACIENTE, MEDICO)**.  

---

## 🚀 Tecnologías utilizadas
- Java 17  
- Spring Boot 3  
- Spring Data JPA  
- Spring Security + JWT  
- Base de datos en memoria **H2** (para pruebas)  
- Lombok  

---

## 📌 Modelo de datos
Las principales entidades son:

- **Persona** → Datos generales (nombre, email, estado).  
- **Usuario** → Credenciales de acceso vinculadas a una persona.  
- **Paciente** → Representa el rol de paciente.  
- **Empleado** → Representa empleados (ADMIN o MEDICO).  
- **Especialidad** → Catálogo de especialidades médicas.  
- **MedicoEspecialidad** → Relación N:M entre médicos y especialidades.  
- **Atención** → Registro de la atención médica (fecha, motivo, paciente, médico).  

---

## 📌 Roles y permisos
- **ADMIN** → Gestiona usuarios, empleados, pacientes, especialidades y atenciones.  
- **MEDICO** → Puede crear y actualizar atenciones, ver sus asignaciones.  
- **PACIENTE** → Puede ver sus propias atenciones.  

---

## 🔐 Seguridad con JWT
- Se implementó autenticación mediante **JWT**.  
- Endpoint para autenticación:  

```http
POST /api/auth/login
