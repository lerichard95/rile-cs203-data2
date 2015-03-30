#Data2 Brainstorm/planning
##Richard Le

#Prompt:
Your bags should be polymorphic, i.e. use generics to allow any kind of contents. By "pure", we mean that operations on the set return new sets and do not modify the old set.

#Requirements
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
[ ] Finish implementing equal() from data1
[ ] Clean up code— add generics

#Research/planning
[ ] Learn what a multiset is
[ ] List properties of multisets
[ ] How to create a hashmap
[ ] Use Java generics examples
[ ] Read about JavaDoc syntax for manual

#Planning the API
[ ] Devise Abstraction strategy- what should be an interface?
  - What operations should be done on the finite bag?
[ ]
[ ]
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
