“​Scenario​: A tuple with w=1.0 is a point

​ 	  ​Given​ a ← tuple(4.3, -4.2, 3.1, 1.0)

​ 	  ​Then​ a.x = 4.3

​ 	    ​And​ a.y = -4.2

​ 	    ​And​ a.z = 3.1

​ 	    ​And​ a.w = 1.0

​ 	    ​And​ a is a point

​ 	    ​And​ a is not a vector”

Excerpt From: Jamis Buck. “The Ray Tracer Challenge”. Apple Books.

“Given​ a ← tuple(4.3, -4.2, 3.1, 0.0)
​ 	  ​Then​ a.x = 4.3
​ 	    ​And​ a.y = -4.2
​ 	    ​And​ a.z = 3.1
​ 	    ​And​ a.w = 0.0
​ 	    ​And​ a is not a point
​ 	    ​And​ a is a vector”

Excerpt From: Jamis Buck. “The Ray Tracer Challenge”. Apple Books.
(the important part here is W=0 means its a vector and W=1 means its a point