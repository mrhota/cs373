cs:
	@echo `pwd`
	@rsync -r -t -u -v --delete \
	--include "makefile"        \
	--include "*.c++"           \
	--include "*.html"          \
	--include "*.py"            \
	--exclude "*"               \
	. downing@$(CS):cs/projects/netflix/
