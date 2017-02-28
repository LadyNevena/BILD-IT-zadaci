package bonus_18_02_2017;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CodingErrorAction;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderWriter {
	
	//pise sadrzaj u file
	public static void write(String filename, String data) {
		String question = "";
		FileInputStream input;

		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {

					question += line + "\n";
				}

			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		question += data + "\n";
		Path path = Paths.get(filename);
		try {
			BufferedWriter writer = Files.newBufferedWriter(path);
			try {
				String[] tempLine = question.split("\n");
				for (int j = 0; j < tempLine.length; j++) {
					writer.write(tempLine[j]);
					writer.newLine();
				}

			} finally {
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//cita korisnicko ime trenutno ulogovanog
	public static String readLogged(String filename) {
		FileInputStream input;
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					return line;
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//write logged
	public static void writeLogged(String filename, String username) {
		Path path = Paths.get(filename);
		try {
			BufferedWriter writer = Files.newBufferedWriter(path); 
			try {
				writer.write(username);
				
			} finally {
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	//cita pitanje za dati broj pitanja
	public static String readQuestion(String filename, String number) {
		FileInputStream input;
		int num = 1;
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (num == Integer.parseInt(number)) {
						return line;
					}
					num++;
				}

			} finally {
				reader.close();
			}
		} catch (

		Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//brise pitanje 
	public static void deleteQuestion(String filename, String number) {
		String question = "";
		FileInputStream input;
		int num = 1;
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (num == Integer.parseInt(number)) {
						num++;
						continue;
					} else {
						question += line + "\n";
					}
					num++;
				}

			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Path path = Paths.get(filename);
		try {
			BufferedWriter writer = Files.newBufferedWriter(path);
			try {
				String[] tempLine = question.split("\n");
				for (int j = 0; j < tempLine.length; j++) {
					writer.write(tempLine[j]);
					writer.newLine();
				}

			} finally {
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	// zamjenjuje pitanje novim unijetim pitanjem
	public static void replaceQuestion(String filename, int number, String newQuestion) {
		String question = "";
		FileInputStream input;
		int num = 1;
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (num == number) {
						question += newQuestion + "\n";
					} else {
						question += line + "\n";
					}
					num++;
				}

			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Path path = Paths.get(filename);
		try {
			BufferedWriter writer = Files.newBufferedWriter(path);
			try {
				String[] tempLine = question.split("\n");
				for (int j = 0; j < tempLine.length; j++) {
					writer.write(tempLine[j]);
					writer.newLine();
				}

			} finally {
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//broj pitanja u fajlu
	public static int numberOfQuestions(String filename) {
		FileInputStream input;
		int counter = 0;
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				while (reader.readLine() != null) {
					counter++;
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return counter;
	}
	
	//brise korisnika
	public static void deleteUser(String filename, String username) {
		String data = "";
		FileInputStream input;
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (line.split(" ")[0].equals(username)) {
						continue;
					} else {
						data += line + "\n";
					}

				}

			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Path path = Paths.get(filename);
		int i = 0;
		try {
			BufferedWriter writer = Files.newBufferedWriter(path);
			try {
				while (i < data.split("\n").length) {
					writer.write(data.split("\n")[i]);
					writer.newLine();
					i++;
				}

			} finally {
				writer.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	//ako korisnik vec postoji u fajlu
	public static boolean alreadyExist(String filename, String data, int k) {
		FileInputStream input;
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {
					if (line.split(" ")[k].equals(data)) {
						return true;
					}
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	//cita sadrzaj iz fajla i vraca listu
	public static java.util.ArrayList<String> readFile(String filename) {
		FileInputStream input;
		java.util.ArrayList<String> list = new java.util.ArrayList<>();
		try {
			input = new FileInputStream(new File(filename));
			CharsetDecoder decoder = Charset.forName("UTF-8").newDecoder();
			decoder.onMalformedInput(CodingErrorAction.IGNORE);
			InputStreamReader readerStream = new InputStreamReader(input, decoder);
			BufferedReader reader = new BufferedReader(readerStream);
			try {
				String line = null;
				while ((line = reader.readLine()) != null) {

					list.add(line);
				}
			} finally {
				reader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
}
