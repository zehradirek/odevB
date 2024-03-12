package com.tobeto.migration;

import org.flywaydb.core.api.migration.BaseJavaMigration;
import org.flywaydb.core.api.migration.Context;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class V1_1_0__encrypt_password extends BaseJavaMigration {
	@Override
	public void migrate(Context context) throws Exception {
		PasswordEncoder encoder = new BCryptPasswordEncoder();

		try (PreparedStatement user = context.getConnection()
				.prepareStatement("select * from user")) {
			try (ResultSet users = user.executeQuery()) {
				while (users.next()) {
					String clearPassword = users.getString("password");
					byte[] id = users.getBytes("id");

					try (PreparedStatement userPasswordUpdate = context.getConnection()
							.prepareStatement("update user set password = ? where id = ?")) {
						userPasswordUpdate.setString(1, encoder.encode(clearPassword));
						userPasswordUpdate.setBytes(2, id);
						userPasswordUpdate.execute();
					}
				}
			}
		}
	}
}
