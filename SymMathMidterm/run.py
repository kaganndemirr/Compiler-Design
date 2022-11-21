import os
import pathlib
import sys

dir_path = os.path.dirname(os.path.realpath(__file__))

if os.path.isdir(os.path.join(dir_path, "out")):
	os.system("javacc Midterm.jj && javac -d " + os.path.join(dir_path, "out") + " *.java && java -cp " + os.path.join(dir_path, "out ") + "MidtermParser < " + str(sys.argv[1]))

else:
	pathlib.Path(os.path.join(dir_path, "out")).mkdir(parents=True, exist_ok=True)
	os.system("javacc Midterm.jj && javac -d " + os.path.join(dir_path, "out") + " *.java && java -cp " + os.path.join(dir_path, "out ") + "MidtermParser < " + str(sys.argv[1]))