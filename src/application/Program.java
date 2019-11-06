package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


import entites.Users;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.print("Enter file full path: ");
		String path = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			Set<Users> us = new HashSet<>();

			String line = br.readLine();
			while (line != null) {
				String[] fields = line.split(" ");
				String name = fields[0];
				Date date = Date.from(Instant.parse(fields[1]));

				us.add(new Users(name, date));

				line = br.readLine();

			}

			System.out.println("Total users: " + us.size());

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}

		sc.close();

	}

}
