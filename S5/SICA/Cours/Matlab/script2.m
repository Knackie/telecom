% Script correspondant à la question b) exercice 6
for i=2:10
    str=['I' num2str(i) '=eye(' num2str(i) ')'];
    eval(str);
end