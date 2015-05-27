/*
 * This program is free software: you can redistribute it and/or modify it under the terms of the
 * GNU General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without
 * even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License along with this program. If
 * not, see <http://www.gnu.org/licenses/>.
 */

package utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVReader;

import user.Professor;

/**
 * @author boinc
 * 
 * Utility methods for the application
 */

public class util {
	
	private final static String RESOURCES_PATH = "src/resources/";
	private final static String PROFESSOR_FILE_NAME = "professeurs.scv";
	private final static String COMMENT_CHAR = "#";
	private final static char SEPARATOR = ';';
	
	private List<Professor> professors;
	
	public void findProfessors() throws IOException {
		File file = new File(RESOURCES_PATH + PROFESSOR_FILE_NAME);
		try {
			FileReader fileReader = new FileReader(file);
			CSVReader csvReader = new CSVReader(fileReader, SEPARATOR);
			List<String[]> data = new ArrayList<String[]>();
			String[] nextLine = null;
			while ((nextLine = csvReader.readNext()) != null) {
				int size = nextLine.length;
				if (size == 0) {
					continue;
				}
				String start = nextLine[0].trim();
				if (start.length() == 0 && size == 1) {
					continue;
				}
				if (start.startsWith(COMMENT_CHAR)) {
					continue;
				}
				data.add(nextLine);
				this.professors = new ArrayList<Professor>();
				for (String[] oneData : data) {
					String firstName = oneData[0];
					String lastName = oneData[1];
					String email = oneData[2];
					String password = (oneData[3] != null) ? oneData[3] : null;
					if (password == null) {
						professors.add(new Professor(firstName, lastName, email));
					} else {
						professors.add(new Professor(firstName, lastName, email, password));
					}
				}
			}
			csvReader.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
