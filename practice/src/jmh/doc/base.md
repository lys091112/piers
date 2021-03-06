## JMH 基础使用

[参考链接-JMH](https://github.com/melix/jmh-gradle-plugin)


Task 

The project will add several tasks:

    jmhClasses : compiles raw benchmark code

    jmhRunBytecodeGenerator : runs bytecode generator over raw benchmark code and generates actual benchmarks

    jmhCompileGeneratedClasses : compiles generated benchmarks

    jmhJar : builds the JMH jar containing the JHM runtime and your compiled benchmark classes

    jmh : executes the benchmarks

The jmh task is the main task and depends on the others so it is in general sufficient to execute this task:

    gradle jmh
    
    
## 配置

    jmh {
       include = ['some regular expression'] // include pattern (regular expression) for benchmarks to be executed
       exclude = ['some regular expression'] // exclude pattern (regular expression) for benchmarks to be executed
       iterations = 10 // Number of measurement iterations to do.
       benchmarkMode = ['thrpt','ss'] // Benchmark mode. Available modes are: [Throughput/thrpt, AverageTime/avgt, SampleTime/sample, SingleShotTime/ss, All/all]
       batchSize = 1 // Batch size: number of benchmark method calls per operation. (some benchmark modes can ignore this setting)
       fork = 2 // How many times to forks a single benchmark. Use 0 to disable forking altogether
       failOnError = false // Should JMH fail immediately if any benchmark had experienced the unrecoverable error?
       forceGC = false // Should JMH force GC between iterations?
       jvm = 'myjvm' // Custom JVM to use when forking.
       jvmArgs = ['Custom JVM args to use when forking.']
       jvmArgsAppend = ['Custom JVM args to use when forking (append these)']
       jvmArgsPrepend =[ 'Custom JVM args to use when forking (prepend these)']
       humanOutputFile = project.file("${project.buildDir}/reports/jmh/human.txt") // human-readable output file
       resultsFile = project.file("${project.buildDir}/reports/jmh/results.txt") // results file
       operationsPerInvocation = 10 // Operations per invocation.
       benchmarkParameters =  [:] // Benchmark parameters.
       profilers = [] // Use profilers to collect additional data. Supported profilers: [cl, comp, gc, stack, perf, perfnorm, perfasm, xperf, xperfasm, hs_cl, hs_comp, hs_gc, hs_rt, hs_thr]
       timeOnIteration = '1s' // Time to spend at each measurement iteration.
       resultFormat = 'CSV' // Result format type (one of CSV, JSON, NONE, SCSV, TEXT)
       synchronizeIterations = false // Synchronize iterations?
       threads = 4 // Number of worker threads to run with.
       threadGroups = [2,3,4] //Override thread group distribution for asymmetric benchmarks.
       timeout = '1s' // Timeout for benchmark iteration.
       timeUnit = 'ms' // Output time unit. Available time units are: [m, s, ms, us, ns].
       verbosity = 'NORMAL' // Verbosity mode. Available modes are: [SILENT, NORMAL, EXTRA]
       warmup = '1s' // Time to spend at each warmup iteration.
       warmupBatchSize = 10 // Warmup batch size: number of benchmark method calls per operation.
       warmupForks = 0 // How many warmup forks to make for a single benchmark. 0 to disable warmup forks.
       warmupIterations = 1 // Number of warmup iterations to do.
       warmupMode = 'INDI' // Warmup mode for warming up selected benchmarks. Warmup modes are: [INDI, BULK, BULK_INDI].
       warmupBenchmarks = ['.*Warmup'] // Warmup benchmarks to include in the run in addition to already selected. JMH will not measure these benchmarks, but only use them for the warmup.

       zip64 = true // Use ZIP64 format for bigger archives
       jmhVersion = '1.21' // Specifies JMH version
       includeTests = true // Allows to include test sources into generate JMH jar, i.e. use it when benchmarks depend on the test classes.
       duplicateClassesStrategy = 'fail' // Strategy to apply when encountring duplicate classes during creation of the fat jar (i.e. while executing jmhJar task)
    }