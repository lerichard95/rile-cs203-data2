#Data2 Brainstorm/planning
##Richard Le

#Prompt:
Your bags should be polymorphic, i.e. use generics to allow any kind of contents. By "pure", we mean that operations on the set return new sets and do not modify the old set.

###Requirements
- Finite bags/multiset
  - each element can occur many times
- Polymorphic (use generics)
- Pure functional implementation
  - return new instances
- Follow properties of finite bags/multisets
- Use iteration abstraction Iterable/sequence/fold...
- Generate test cases
  - test-first programming?

===

#Tasks:
###Legend
[~] in progress
[x] completed
[ ] to do
[ ] 

===


[x] Finish implementing equal() from data1

[x] Rewrite/refactor FiniteSets to FiniteBag, write JavaDoc for functions
[~] Write API (interface) for FiniteBag

##Concrete Implementations
[x] Refactor/rewrite Leaf
[x] Add generics to Leaf
[x] Make generics comparable for Leaf

[x] Rewrite/refactor Tree, write JavaDoc for functions
[x] Rebuild constructor for Tree to accomodate int count
[x] Add generics to Tree
[~] Make generics comparable for Tree
	- issue: Use comparable methods in the generics for implementing an AVL tree...

[ ] 

PROCESS:
1. Write JavaDoc for functions
2. Write tests for function
3. Write implementations

##Testing
[ ] Retool the random tree generation to work with generics...
[ ] Rewrite tests to work with generics/AVL trees...

##Writing implementations
[ ] Comment out unused functions

===

#Research/planning
[x] Learn what a multiset is
[ ] List properties of multisets

[ ] How to create a hashmap
[x] Use Java generics examples
[x] Read about JavaDoc syntax for manual

###JavaDoc research
Cheatsheet for JavaDoc:
http://www.liferay.com/community/wiki/-/wiki/Main/Javadoc+Guidelines#section-Javadoc+Guidelines-Constructor:+with+parameters

###Tester Library
http://www.ccs.neu.edu/javalib/Tester/

###CS Bags (specific)
http://algs4.cs.princeton.edu/13stacks/

###Bags (math):
http://en.wikipedia.org/wiki/Multiset

###CS Bags:
http://en.wikipedia.org/wiki/Set_(abstract_data_type)#Multiset

#Planning the API
===
[x] Devise Abstraction strategy- what should be an interface?
  - What operations should be done on the finite bag?
  - Can items be removed from finite bags?
[ ]
[ ] 


#Submission
===

You should turn in your source code, a console transcript of your test suite’s execution, and an essay which describes your approach to implementing and verifying the system. Your essay should probably make reference to specific lines in your source code and test transcript.

You will be graded on the persuasiveness of your essay.

However, you also need to turn in a manual for your library. The library should document the API, describe its use, explain the properties that hold between API calls, and present performance characteristics. I recommend using a tool like Javadoc to help you make this manual.

You will be graded on the thoroughness of your manual.

These two pieces of the project will be weighted equally.

===

#Submission Checklist

[ ] Source code /src
[ ] Console transcript
[ ] Essay
  - explain approach to implementing and verifying the system
[ ] API/library manual
  - Document the API's functions
  - Describe the uses
  - Explain properties
  - Performance characteristics (linear, log, etc?)
