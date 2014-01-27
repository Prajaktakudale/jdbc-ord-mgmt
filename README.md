#Expression Evaluator

##How to Install
1.Extract .zip folder  
2.Create new environment variable named `EVALUATOR_HOME` Set the path of your folder in this Variable (don't include bin in path)   
3.In PATH veriable at last give ';' and continue with `%EVALUATOR_HOME%\bin` and save it.   
##How to run
1.Open command line (bash)   
2.Type command `sh EvalSh.sh "8 + 8"`

##How to use

##Version 0.7

1.Give positive and negative numbers.           
2.Multiple brackets will accepted in expression.        
3.Give two or more than two operands and operators.
4.Space is not needed between operands and operators.                    
5.It will evaluate expression of integers and float with following operators          
    +,-,*,/,^
    
    Example.  
           1+1 result 2.0
           -1-1 result -2.0

##Version 0.6

1.Give positive numbers.         
2.Multiple brackets will accepted in expression.     
2.Give two or more than two operands and operators.                 
3.Space is needed between operands,operators and brackets.                
4.It will evaluate expression of integers and float with following operators          
    +,-,*,/,^
    
    Example.  
           2.0 + 1.0 result 3.0


##Version 0.5

1.Give positive numbers.         
2.Multiple brackets will accepted in expression.     
2.Give two or more than two operands and operators.                 
3.Space is needed between operands,operators and brackets.                
4.It will evaluate expression of two integers with following operators          
    +,-,*,/,^
    
    Example.  
            4 + 5 - ( 2 * 3 ) result 14        
            4 + 5 + ( 4 + ( 4 + 4 ) ) result 21

##Version 0.4

1.Give positive numbers.       
2.Brackets will accepted in expression.
2.Give two or more than two operands and operators.           
3.Space is needed between operands,operators and brackets.          
4.It will evaluate expression of two integers with following operators     
    +,-,*,/,^
    
    Example.  
            4 + 5 - ( 2 * 3 ) result 14
            
##Version 0.3

1.Give positive numbers.    
2.Give two or more than two operands and operators     
3.Space is needed between operands and operators.     
4.It will evaluate expression of two integers with following operators     
    +,-,*,/,^
    
    Example.  
            4 + 5 - 2 * 3 / 3 ^ 2 result 49

##Version 0.2

1.Give positive numbers.
2.Give two operands and one operator
3.Space is needed between operands and operators.
4.It will evaluate expression of two integers with following operators
    +,-,*,/,^
    
    Example.  
            4 + 4 result 8.0
    	    8 - 4 result 4.0
	        8 * 2 result 16.0
	        8 / 4 result 2.0
	        2 ^ 3 result 8.0

##Version 0.1

1.Give positive numbers. 
2.Give two operands and one operator   
3.Space is needed between operands and operators.  
4.It will perform only addition operation.  

     Example. "8 + 8" = 16  
