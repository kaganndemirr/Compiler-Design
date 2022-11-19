import os
import shutil

dir_path = os.path.dirname(os.path.realpath(__file__))

gitignore_list = ["out", "MidtermParser.java", "MidtermParserConstants.java", "MidtermParserTokenManager.java",
				  "SimpleCharStream.java", "SimpleCharStream.java", "Token.java", "TokenMgrError.java", "ParseException.java"]

for obj in os.listdir(dir_path):
	if obj in gitignore_list:
		if os.path.isdir(os.path.join(dir_path, obj)):
			shutil.rmtree(os.path.join(dir_path, obj))
		else:
			os.remove(os.path.join(dir_path, obj))
