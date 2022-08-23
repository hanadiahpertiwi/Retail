package com.ERetail.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class SupplierDto {

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class CreateSupplierDto {

		private String namaSupplier;
		private String email;
		private String noTelp;
		private String alamatSupplier;
		private long idRegion;
	}

	@Data
	@AllArgsConstructor
	@NoArgsConstructor
	public static class UpdateSupplierDto {

		private Long idSupplier;
		private String namaSupplier;
		private String email;
		private String noTelp;
		private String alamatSupplier;
		private Long idRegion;
	}
}
