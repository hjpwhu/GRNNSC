package org.hjp.grnnsc.data;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class word2embedding {

	public static void main(String[] args) {
		String dirName = "/Users/hjp/Workshop/Model/grnnsc/data";
		listFile(dirName);

	}

	public static void listFile(String dirName) {
		try {
			File pathName = new File(dirName);
			String[] fileNames = pathName.list();

			for (int i = 0; i < fileNames.length; i++) {
				File f = new File(pathName.getPath(), fileNames[i]);

				if (f.isDirectory()) {
					System.out.println(f.getCanonicalPath());
					listFile(f.getPath());
				} else {
					// System.out.println(f.getAbsolutePath());
					readFile(f.getAbsolutePath());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void readFile(String filePath) {
		if (filePath.endsWith(".ss")) {
			BufferedReader in;
			try {
				in = new BufferedReader(new FileReader(filePath));

				String line;
				while ((line = in.readLine()) != null) {
					if (line.length() != 0) {
						String[] terms = line.split("\t");
						System.out.println(terms[terms.length - 1]);
						writeFile(terms[terms.length - 1].replaceAll("<sssss>", ""));
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static void writeFile(String content) {
		String filePath = "/Users/hjp/Workshop/Model/grnnsc/data/train_dev.txt";
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
			writer.write(content + "\r\n");
			writer.flush();
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
