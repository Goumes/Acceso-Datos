CREATE PROCEDURE insertarMascotaEnfermedad (@nombreEnfermedad VARCHAR (50), @fecha DATE, @codigoMascota CHAR (5))
AS
BEGIN
	DECLARE @idEnfermedad SMALLINT

	SELECT @idEnfermedad = ID
		FROM BI_Enfermedades
		WHERE Nombre = @nombreEnfermedad

		INSERT INTO BI_Mascotas_Enfermedades (IDEnfermedad, Mascota, FechaInicio)
		VALUES (@idEnfermedad, @codigoMascota, @fecha)
END

GO


EXECUTE insertarMascotaEnfermedad 'Borreliosis','20160601', 'PM001' --Prueba correcta
