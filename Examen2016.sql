ALTER PROCEDURE insertarMascotaEnfermedad (@nombreEnfermedad VARCHAR (50), @fecha DATE, @codigoMascota CHAR (5))
AS
BEGIN
	DECLARE @idEnfermedad SMALLINT

	IF NOT EXISTS((SELECT ID
					FROM BI_Enfermedades
					WHERE Nombre = @nombreEnfermedad))
	BEGIN
		RAISERROR ('Esta enfermedad no existe', -- Message text.
					5, -- Severity.
					1 -- State.
					);
	END

	ELSE IF NOT EXISTS ((SELECT Codigo
							FROM BI_Mascotas
							WHERE Codigo = @codigoMascota))
	BEGIN
		RAISERROR ('Esta mascota no existe', -- Message text.
					5, -- Severity.
					1 -- State.
					);
	END

	ELSE
	BEGIN
		SELECT @idEnfermedad = ID
			FROM BI_Enfermedades
			WHERE Nombre = @nombreEnfermedad

			INSERT INTO BI_Mascotas_Enfermedades (IDEnfermedad, Mascota, FechaInicio)
			VALUES (@idEnfermedad, @codigoMascota, @fecha)
	END
END

GO


EXECUTE insertarMascotaEnfermedad 'Borreliosis','20160601', 'PM001' --Prueba correcta