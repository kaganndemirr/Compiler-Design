import os
import pathlib

dir_path = os.path.dirname(os.path.realpath(__file__))

input_file = "Input1.txt"

if os.path.isdir(os.path.join(dir_path, "out")):
	os.system("javacc Midterm.jj && javac -d " + os.path.join(dir_path, "out") + " *.java && java -cp " + os.path.join(dir_path, "out ") + "MidtermParser < " + input_file)

else:
	pathlib.Path(os.path.join(dir_path, "out")).mkdir(parents=True, exist_ok=True)
	os.system("javacc Midterm.jj && javac -d " + os.path.join(dir_path, "out") + " *.java && java -cp " + os.path.join(dir_path, "out ") + "MidtermParser < " + input_file)