# Static Analysis Tool Using PMD

## Introduction

This repository contains a dynamic analysis tool for collecting static analysis results (by PMD) along with a revision
history for a further repository mining. This information is then summarized and output in a JSON file.

## Table of Contents

- [Requirements](#requirements)
- [Usage](#usage)
- [Output](#output)
- [Performance](#performance)
- [Testing](#testing)

## Requirements

**R1** Any programming language can be used.

**R2** Your program should be shared by a GitHub or Bitbucket repository.

**R3**  In your repository, there should be “README.md” explaining how to run your program.

**R4** Using Docker is highly recommended for setting up a running environment but it is
optional.

**R5** Your program should take a git repository location as input; the git repository is a Java
project.

**R6** Your program shall take other optional parameters if necessary.

**R7** Your program shall produce a JSON file as output for each commit; this should be stored
into a designated location by an optional parameter.

**R8** Your program shall produce a file summarizing the results of running PMD along with
the history of the target project; the format should be as follows:

```json
{
  "location": "/a/b/c",
  "stat_of_repository": {
    "number_of_commits": 101,
    "avg_of_num_java_files": 30.2,
    "avg_of_num_warnings": 193.2
  },
  "stat_of_warnings": {
    "AbstractClassWithoutAbstractMethod": 1908,
    "AvoidReassigningCatchVariables": 2020
  }
}
```

**R9** Your program should take a ruleset file path as a parameter.

**R10** Your program should perform, at least, 1.0s/commit. In other words, your program shall finish processing a
repository with 1,000 commits within 1000s.

**R11** You can test your program with
the [https://github.com/apache/commons-lang](https://github.com/apache/commons-lang) repository.

## Usage

### Prerequisites

Before you can run this project, you need to have the following software installed on your system:

- **Docker:** Install [Docker](https://docs.docker.com/engine/install/) using this link if docker not exists in your 
system, if you want to check docker exits or not then run this:
   ```sh
   docker --version
   ```
  if you got output similar to this **"Docker version 20.10.23, build 7155243"** it means docker exists

### Running the Project

To run the project locally, follow these steps:

1. Clone this repository to your local machine using Git:
   ```sh
   git clone https://github.com/ammaralii/java-pmd-analyzer.git
   ```
2. Navigate to the project directory:
    ```sh
   cd java-pmd-analyzer
    ```
3. Build docker image:
    ```sh
   docker build -t pmd-analyzer:latest .
    ```
3. Run the application:
    ```sh
   docker run pmd-analyzer:latest
    ```

## Output

The tool will produce a JSON file output.

## Performance

The tool is designed to meet the performance requirements outlined in Requirement R10. It should be capable of processing
a repository with 1,000 Java files within 1000 seconds.

I made it superfast as it'll process 1 java file in 100-150 milliseconds. Here is the output where I processed **7922**
java files in **61.231** seconds
```
Step 1: (Get the list of commits in the git repository)
Step 1 Execution Completed!
Step 1 Execution Time: 12 ms
Step 2: (Collect static analysis results for each commit)
Analysis started on commit: 44d870b83d5c0aebaec6759927518b611bd7baa5
No Java files found in commit
Analysis started on commit: 660e2699d169cf46e8b9d9b5d57c166491456d3e
No Java files found in commit
Analysis started on commit: 4473141d250c11c3fbaad48139e169180729d3e7
No Java files found in commit
Analysis started on commit: 5308b08caca7702082286bc31b55c3175573a22e
No Java files found in commit
Analysis started on commit: f50e00acf42e643b3bdde0e4c968d114922eca3b
No Java files found in commit
Analysis started on commit: 29a893f1aa5bd09dec077f4784adbf3b761e5bbb
No Java files found in commit
Analysis started on commit: 16e39e4a44f074da904e2b5958519b5f5e0293f5
Java files found in commit: 5
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/16e39e4a44f074da904e2b5958519b5f5e0293f5.json
Analysis started on commit: fa907cf9a6c0ba52bc79575f55e5cabbb5192cba
Java files found in commit: 5
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/fa907cf9a6c0ba52bc79575f55e5cabbb5192cba.json
Analysis started on commit: 4ca3cc5bf930c071aec103e645e0e7a330a441e9
Java files found in commit: 14
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/4ca3cc5bf930c071aec103e645e0e7a330a441e9.json
Analysis started on commit: 93f08484c2ebbe4a425738071252ad164be49433
Java files found in commit: 14
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/93f08484c2ebbe4a425738071252ad164be49433.json
Analysis started on commit: b8a980ca291ae8848438e296199fae295655d482
Java files found in commit: 14
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/b8a980ca291ae8848438e296199fae295655d482.json
Analysis started on commit: 14c310e61ff6ffaa3b9cf911a74271cebeaaf837
Java files found in commit: 14
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/14c310e61ff6ffaa3b9cf911a74271cebeaaf837.json
Analysis started on commit: d1dc342b4bf909fdb3f0d95410781a025bced7f1
Java files found in commit: 14
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d1dc342b4bf909fdb3f0d95410781a025bced7f1.json
Analysis started on commit: c05c9c39f56e45b317082249e884a1dfbfa4c3e8
Java files found in commit: 14
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/c05c9c39f56e45b317082249e884a1dfbfa4c3e8.json
Analysis started on commit: 85ebeb3307cd953905b24c2ad8b5966f6cb5dda6
Java files found in commit: 14
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/85ebeb3307cd953905b24c2ad8b5966f6cb5dda6.json
Analysis started on commit: 5b5720df1a1a69e246de9788df85ff3e9f7b25b2
Java files found in commit: 14
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5b5720df1a1a69e246de9788df85ff3e9f7b25b2.json
Analysis started on commit: becdafe620d14882d79fbebce79bc84dbc78cf24
Java files found in commit: 16
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/becdafe620d14882d79fbebce79bc84dbc78cf24.json
Analysis started on commit: 9e9b243157e0a34acf906e76a707892341faa98d
Java files found in commit: 16
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9e9b243157e0a34acf906e76a707892341faa98d.json
Analysis started on commit: 6b8f7d4e922fe43ab7c4abc9d20dd420084fe669
Java files found in commit: 17
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/6b8f7d4e922fe43ab7c4abc9d20dd420084fe669.json
Analysis started on commit: 9bc8744d52a6e7f8f0f9000104bbcb77e6f38550
Java files found in commit: 20
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9bc8744d52a6e7f8f0f9000104bbcb77e6f38550.json
Analysis started on commit: d45fc27cbd5e984022493ea983b5fcc06765463c
Java files found in commit: 20
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d45fc27cbd5e984022493ea983b5fcc06765463c.json
Analysis started on commit: efe32e905767fe73dfbba3b656cae65a7d70c7b5
Java files found in commit: 21
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/efe32e905767fe73dfbba3b656cae65a7d70c7b5.json
Analysis started on commit: 90b4aff012ebc41dbd743fbee39f65217efedbde
Java files found in commit: 21
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/90b4aff012ebc41dbd743fbee39f65217efedbde.json
Analysis started on commit: 908f9254d6af2aba5a770532892b6901560f150a
Java files found in commit: 21
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/908f9254d6af2aba5a770532892b6901560f150a.json
Analysis started on commit: 1c823f7e1677decabd96a3a48e174b7fadf84d74
Java files found in commit: 21
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1c823f7e1677decabd96a3a48e174b7fadf84d74.json
Analysis started on commit: 61f53046340e7f224888ee14daf8c061392aad4a
Java files found in commit: 24
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/61f53046340e7f224888ee14daf8c061392aad4a.json
Analysis started on commit: 359f65f2f862be545bc2ab89eb5ef48eb5d5f711
Java files found in commit: 24
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/359f65f2f862be545bc2ab89eb5ef48eb5d5f711.json
Analysis started on commit: 61ba4b4ecb1ba803718954b12d077157ea16c048
Java files found in commit: 24
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/61ba4b4ecb1ba803718954b12d077157ea16c048.json
Analysis started on commit: 2fd59f4898d89835b1e97bb320429cbe06bb328b
Java files found in commit: 24
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2fd59f4898d89835b1e97bb320429cbe06bb328b.json
Analysis started on commit: 62df651e12b5bfcfd272d36b23303fd135e216c5
Java files found in commit: 25
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/62df651e12b5bfcfd272d36b23303fd135e216c5.json
Analysis started on commit: 1e7fe6c9ebb942a1a96ea87d0fcfe879c2fed7e3
Java files found in commit: 26
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1e7fe6c9ebb942a1a96ea87d0fcfe879c2fed7e3.json
Analysis started on commit: fc2af949d0660de67aa67404834ff47c8a6b1527
Java files found in commit: 28
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/fc2af949d0660de67aa67404834ff47c8a6b1527.json
Analysis started on commit: d4bab9f601d72c4d12423e6397269a077796486f
Java files found in commit: 28
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d4bab9f601d72c4d12423e6397269a077796486f.json
Analysis started on commit: 2c1167cb6cb76dcf7ff853e476d2bcb637cb051d
Java files found in commit: 28
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2c1167cb6cb76dcf7ff853e476d2bcb637cb051d.json
Analysis started on commit: 877d30eeb942bd2837439c7099b441cebf71a487
Java files found in commit: 29
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/877d30eeb942bd2837439c7099b441cebf71a487.json
Analysis started on commit: 3eae137d87bdc93a0cb3a8e2e67652ae5f5df453
Java files found in commit: 29
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/3eae137d87bdc93a0cb3a8e2e67652ae5f5df453.json
Analysis started on commit: 2cdb0298cc7b10de3b94b895f254702fbfd00908
Java files found in commit: 29
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2cdb0298cc7b10de3b94b895f254702fbfd00908.json
Analysis started on commit: 4d13feea80221fe946c6a09998ed1a98e5ac36f1
Java files found in commit: 29
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/4d13feea80221fe946c6a09998ed1a98e5ac36f1.json
Analysis started on commit: f270cdad00b420a473c9f943a734a7b6a5a1a3f7
Java files found in commit: 29
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/f270cdad00b420a473c9f943a734a7b6a5a1a3f7.json
Analysis started on commit: 64a0f12585bd70212614cc0ef2f0ce76da09c1cb
Java files found in commit: 29
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/64a0f12585bd70212614cc0ef2f0ce76da09c1cb.json
Analysis started on commit: f2ef525fb17f1041eb0b75fef8c334e67ec29fc2
Java files found in commit: 31
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/f2ef525fb17f1041eb0b75fef8c334e67ec29fc2.json
Analysis started on commit: 86e3be56de6ec99679342544e2a251dcdbc94336
Java files found in commit: 31
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/86e3be56de6ec99679342544e2a251dcdbc94336.json
Analysis started on commit: f3b9339939a889d20ac6d79b1c2d3642d2dea736
Java files found in commit: 33
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/f3b9339939a889d20ac6d79b1c2d3642d2dea736.json
Analysis started on commit: 5293fe2d136dc38ca01473330d6f5d2e1f0ea6a0
Java files found in commit: 33
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5293fe2d136dc38ca01473330d6f5d2e1f0ea6a0.json
Analysis started on commit: 9622b0d0833dfbbeb7569cc4bcd3e6b5b8dcb82b
Java files found in commit: 35
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9622b0d0833dfbbeb7569cc4bcd3e6b5b8dcb82b.json
Analysis started on commit: 7bf3226024e2567e4548defd8cc7ae2dc21d894a
Java files found in commit: 37
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/7bf3226024e2567e4548defd8cc7ae2dc21d894a.json
Analysis started on commit: e856d0d661c4284167d4a89d3160b4f2eb6b75ca
Java files found in commit: 39
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e856d0d661c4284167d4a89d3160b4f2eb6b75ca.json
Analysis started on commit: cd47b3862afe75759e50544d8bb438635f863c95
Java files found in commit: 39
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/cd47b3862afe75759e50544d8bb438635f863c95.json
Analysis started on commit: 2b8d373ba6a017dc3d1e7f65afce82fbaa5b9f5b
Java files found in commit: 39
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2b8d373ba6a017dc3d1e7f65afce82fbaa5b9f5b.json
Analysis started on commit: 9d7fd41de4825afc25f9f7e5637ed3304ab032a4
Java files found in commit: 39
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9d7fd41de4825afc25f9f7e5637ed3304ab032a4.json
Analysis started on commit: e8780714100da4dac82b26dbafbffd649c06a5b7
Java files found in commit: 43
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e8780714100da4dac82b26dbafbffd649c06a5b7.json
Analysis started on commit: ad3af745075d51f6f7dd82e798b2b372c801e16d
Java files found in commit: 55
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/ad3af745075d51f6f7dd82e798b2b372c801e16d.json
Analysis started on commit: d5e1a8b06ee4bf941722333a26795e7695f9e6cc
Java files found in commit: 55
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d5e1a8b06ee4bf941722333a26795e7695f9e6cc.json
Analysis started on commit: 10ee11621c5e6810351085cd6356efbacdf58a7b
Java files found in commit: 56
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/10ee11621c5e6810351085cd6356efbacdf58a7b.json
Analysis started on commit: 099ac491ccb2f183587b4fdf41446ffecceba292
Java files found in commit: 56
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/099ac491ccb2f183587b4fdf41446ffecceba292.json
Analysis started on commit: 93e4586a82cfd948fcb065ed3ea84119e8eba27b
Java files found in commit: 56
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/93e4586a82cfd948fcb065ed3ea84119e8eba27b.json
Analysis started on commit: 5b2551a837fd65bbee0925c15220651c5d7239a8
Java files found in commit: 56
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5b2551a837fd65bbee0925c15220651c5d7239a8.json
Analysis started on commit: 92cf291d0edcb52f3fa187a4cc59c5f848aa2c7a
Java files found in commit: 55
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/92cf291d0edcb52f3fa187a4cc59c5f848aa2c7a.json
Analysis started on commit: 1407de3a30800133c65e4e8dff56b313ce5b6bd8
Java files found in commit: 57
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1407de3a30800133c65e4e8dff56b313ce5b6bd8.json
Analysis started on commit: 93fc5749b004103cf5dc0cbcd808373aef8e24ba
Java files found in commit: 56
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/93fc5749b004103cf5dc0cbcd808373aef8e24ba.json
Analysis started on commit: a61cd0eabc3ae5857026a73ccd358739cd8db950
Java files found in commit: 58
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/a61cd0eabc3ae5857026a73ccd358739cd8db950.json
Analysis started on commit: d31eb5b72202b6a14906f88e329d1d051ad6bdc1
Java files found in commit: 60
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d31eb5b72202b6a14906f88e329d1d051ad6bdc1.json
Analysis started on commit: 2bee6dfa718d256f79a67c5573cf39a2fbec5cca
Java files found in commit: 62
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2bee6dfa718d256f79a67c5573cf39a2fbec5cca.json
Analysis started on commit: ae20a7784f7214c187c5575a936b2320794c54a6
Java files found in commit: 63
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/ae20a7784f7214c187c5575a936b2320794c54a6.json
Analysis started on commit: 9738db2e99e40cb7a25a90ed4b1d6888a108b033
Java files found in commit: 64
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9738db2e99e40cb7a25a90ed4b1d6888a108b033.json
Analysis started on commit: 093a9ff25032436db0032944e6afc554da45e458
Java files found in commit: 66
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/093a9ff25032436db0032944e6afc554da45e458.json
Analysis started on commit: 241a324a6e5ba869ffc9b5368b8d6be97e533b43
Java files found in commit: 68
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/241a324a6e5ba869ffc9b5368b8d6be97e533b43.json
Analysis started on commit: 5de12fc6de44b5fcff497deb2893c0ea5043dd5f
Java files found in commit: 70
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5de12fc6de44b5fcff497deb2893c0ea5043dd5f.json
Analysis started on commit: 9dbc81cb39486013a82743bd606fc4f0df3962a3
Java files found in commit: 70
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9dbc81cb39486013a82743bd606fc4f0df3962a3.json
Analysis started on commit: 91cf95f9ec921938e8467ee81a1e154814946c4a
Java files found in commit: 70
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/91cf95f9ec921938e8467ee81a1e154814946c4a.json
Analysis started on commit: 5bf0d8d032a0e5e12624acfe2969a1cd9384e022
Java files found in commit: 74
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/5bf0d8d032a0e5e12624acfe2969a1cd9384e022.json
Analysis started on commit: 918288378db1dae2bf10d483cd015214abebfc7e
Java files found in commit: 74
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/918288378db1dae2bf10d483cd015214abebfc7e.json
Analysis started on commit: 1f5a497eaa0e09c410bf1bd0db2ccd1f8ba6e7c3
Java files found in commit: 78
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1f5a497eaa0e09c410bf1bd0db2ccd1f8ba6e7c3.json
Analysis started on commit: a78a46319bd030dab0e2e7010624d4a5d1a9bc36
Java files found in commit: 79
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/a78a46319bd030dab0e2e7010624d4a5d1a9bc36.json
Analysis started on commit: ac3e5f0ff85829ecbc3d45fe392f1a867049ca78
Java files found in commit: 80
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/ac3e5f0ff85829ecbc3d45fe392f1a867049ca78.json
Analysis started on commit: 94a8c087461c1b140522f7c3901384a40057e697
Java files found in commit: 80
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/94a8c087461c1b140522f7c3901384a40057e697.json
Analysis started on commit: dd09c7644121abad07db06fd09faff5092b55b6f
Java files found in commit: 80
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/dd09c7644121abad07db06fd09faff5092b55b6f.json
Analysis started on commit: 1c64df247beb502b8dd415eb55fe678169a8ecb3
Java files found in commit: 94
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1c64df247beb502b8dd415eb55fe678169a8ecb3.json
Analysis started on commit: c4f70fbec584c797af6725cd56d1362a62c1c500
Java files found in commit: 96
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/c4f70fbec584c797af6725cd56d1362a62c1c500.json
Analysis started on commit: e5dc8298f6ac057f6039848aea18d57166a2e379
Java files found in commit: 98
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e5dc8298f6ac057f6039848aea18d57166a2e379.json
Analysis started on commit: 2b9a1b61fa8ea4987cbd02b872aa0d86fb56cb49
Java files found in commit: 113
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2b9a1b61fa8ea4987cbd02b872aa0d86fb56cb49.json
Analysis started on commit: dcf148c6f73cf6d7d1c3b8c766ce9ad652315f0b
Java files found in commit: 114
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/dcf148c6f73cf6d7d1c3b8c766ce9ad652315f0b.json
Analysis started on commit: a50374492b7682e8c14530b81344b1eca87a2412
Java files found in commit: 115
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/a50374492b7682e8c14530b81344b1eca87a2412.json
Analysis started on commit: f84e56f3431c7f4b96b31ae7f9dc7ca6f7725632
Java files found in commit: 115
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/f84e56f3431c7f4b96b31ae7f9dc7ca6f7725632.json
Analysis started on commit: 77db8e7280295442a592518d53e1ca7d73f3ce48
Java files found in commit: 117
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/77db8e7280295442a592518d53e1ca7d73f3ce48.json
Analysis started on commit: 2375e645a39796b87313fe626e6a4963cff7e313
Java files found in commit: 117
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2375e645a39796b87313fe626e6a4963cff7e313.json
Analysis started on commit: c149a29b4c05483a909d2dd6654e6f373969e19c
Java files found in commit: 117
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/c149a29b4c05483a909d2dd6654e6f373969e19c.json
Analysis started on commit: 8a55a1e14d0ee253ca4cd2915a3a8e07c97b3cb0
Java files found in commit: 119
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/8a55a1e14d0ee253ca4cd2915a3a8e07c97b3cb0.json
Analysis started on commit: 25bb4b596f734a3dc77c431a9eff4b4536273f76
Java files found in commit: 121
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/25bb4b596f734a3dc77c431a9eff4b4536273f76.json
Analysis started on commit: bcc5fa444bc16b6fbc4d1b88255f063172dfcc13
Java files found in commit: 123
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/bcc5fa444bc16b6fbc4d1b88255f063172dfcc13.json
Analysis started on commit: 9e1e72d0e4633a27175c358501932195e3e809e6
Java files found in commit: 123
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/9e1e72d0e4633a27175c358501932195e3e809e6.json
Analysis started on commit: 2ad007ac3d78649ef4b1d1dfb1530d1dc8bbcbbb
Java files found in commit: 124
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2ad007ac3d78649ef4b1d1dfb1530d1dc8bbcbbb.json
Analysis started on commit: 94bb4da8076a15ca679849dbe7baeef98be2a5d9
Java files found in commit: 124
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/94bb4da8076a15ca679849dbe7baeef98be2a5d9.json
Analysis started on commit: ef141d402ad2eed4a2b7a74ac15c22d57f920eec
Java files found in commit: 174
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/ef141d402ad2eed4a2b7a74ac15c22d57f920eec.json
Analysis started on commit: 2b5716dd7e28ff45abecf3364028fe193df85b14
Java files found in commit: 174
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2b5716dd7e28ff45abecf3364028fe193df85b14.json
Analysis started on commit: 38d9df62b83af07adccd24ae97458543029b4c62
Java files found in commit: 174
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/38d9df62b83af07adccd24ae97458543029b4c62.json
Analysis started on commit: e427595c2cc1b94b753ccd3a6dbb9b0e5eb248a6
Java files found in commit: 174
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e427595c2cc1b94b753ccd3a6dbb9b0e5eb248a6.json
Analysis started on commit: b617c01388477b0ff88e36c43dfef162632ceaca
Java files found in commit: 174
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/b617c01388477b0ff88e36c43dfef162632ceaca.json
Analysis started on commit: d520c518ee47e2c7fb56005f8e4c44e9709e6952
Java files found in commit: 174
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/d520c518ee47e2c7fb56005f8e4c44e9709e6952.json
Analysis started on commit: 1ce9e470b6c5096c539793ecfbb84d5b90852330
Java files found in commit: 174
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/1ce9e470b6c5096c539793ecfbb84d5b90852330.json
Analysis started on commit: 0cf53ca67a631cbb667f2cb5b59b7b10c6473809
Java files found in commit: 174
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/0cf53ca67a631cbb667f2cb5b59b7b10c6473809.json
Analysis started on commit: bed3968f4c89a18d5fe2f443eb04fb03e9993563
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/bed3968f4c89a18d5fe2f443eb04fb03e9993563.json
Analysis started on commit: 739ea290ded9f4e69d38ac4abde3f7255754e3da
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/739ea290ded9f4e69d38ac4abde3f7255754e3da.json
Analysis started on commit: fa45f92247f4318b7df96732c0f6f170d2616b09
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/fa45f92247f4318b7df96732c0f6f170d2616b09.json
Analysis started on commit: 3613e15edd8feb3c572927ba8ddba42830062663
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/3613e15edd8feb3c572927ba8ddba42830062663.json
Analysis started on commit: 201f6982b41f5c565d77532d29d68aae5ee58eaa
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/201f6982b41f5c565d77532d29d68aae5ee58eaa.json
Analysis started on commit: 14a3ca3957d2dfadd4409f0298870a092e2bc3c2
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/14a3ca3957d2dfadd4409f0298870a092e2bc3c2.json
Analysis started on commit: 40777faba66a813a8e525bb4052c5b42ee8b4163
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/40777faba66a813a8e525bb4052c5b42ee8b4163.json
Analysis started on commit: 3ce2908ed3c6fdbd714646c1536433f61efc2046
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/3ce2908ed3c6fdbd714646c1536433f61efc2046.json
Analysis started on commit: 8544d76a08403311f80666acf719998f33f3c146
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/8544d76a08403311f80666acf719998f33f3c146.json
Analysis started on commit: e4de60cf9627bedab3006a705b9693b24e13ca24
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/e4de60cf9627bedab3006a705b9693b24e13ca24.json
Analysis started on commit: 2e57730dbb88d9a349593e8a5e7f1c3df7b172a9
Java files found in commit: 173
PMD analysis commit file Location: pmd-analyzer-projects/interview-preparation-kit/pmd-stats-on-commit/2e57730dbb88d9a349593e8a5e7f1c3df7b172a9.json
Step 2 Execution Completed!
Step 2 Execution Time: 61231 ms
Final JSON Object:
{"location":"/Users/ammarali/home/projects/pmd-analyzer/pmd-analyzer-projects/interview-preparation-kit","stat_of_repository":{"number_of_commits":112,"avg_of_num_warnings":185.54,"avg_of_num_java_files":70.73},"stat_of_warnings":{"UseEqualsToCompareStrings":136,"UseUtilityClass":3753,"LooseCoupling":332,"LocalVariableNamingConventions":676,"UnusedPrivateMethod":213,"FormalParameterNamingConventions":270,"UnnecessaryLocalBeforeReturn":61,"UnnecessaryFullyQualifiedName":62,"ForLoopCanBeForeach":510,"CloseResource":467,"SwitchStmtsShouldHaveDefault":82,"DoNotExtendJavaLangThrowable":78,"UselessParentheses":728,"ControlStatementBraces":1496,"MethodNamingConventions":10330,"SimplifyBooleanReturns":93,"AvoidBranchingStatementAsLastInLoop":62,"LiteralsFirstInComparisons":238,"OneDeclarationPerLine":515,"CompareObjectsWithEquals":136,"UseCollectionIsEmpty":122,"UnusedLocalVariable":34,"UncommentedEmptyConstructor":97,"UnnecessaryImport":289}}
```

## Testing

You can test the tool with the [https://github.com/apache/commons-lang](https://github.com/apache/commons-lang)
repository as suggested in Requirement R11.

Happy coding! Life is Logically programmed