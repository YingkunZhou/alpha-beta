# amazon

Why use serverless?
--------
Building serverless applications means that your developers can focus on their core product instead of worrying about managing and operating servers or runtimes, either in the cloud or on-premises. This reduced overhead lets developers reclaim time and energy that can be spent on developing great products which scale and that are reliable.

The AWS serverless platform // AWS 无服务器平台
---------
AWS 可提供一系列完全托管的服务，您可以使用它们构建和运行无服务器应用程序。无服务器应用程序无需为后端组件（如计算、数据库、存储、流处理、消息排队等）预置、维护和管理服务器。此外，您再也无需担心应用程序的容错能力和可用性了。相反，AWS 会为您处理所有这些功能。这使您可以专注于产品创新，同时实现更快的上市时间。

AWS provides a set of fully managed services that you can use to build and run serverless applications. Serverless applications don’t require provisioning, maintaining, and administering servers for backend components such as compute, databases, storage, stream processing, message queueing, and more. You also no longer need to worry about ensuring application fault tolerance and availability. Instead, AWS handles all of these capabilities for you. This allows you to focus on product innovation while enjoying faster time-to-market.

## how aws lambda works

Lambda Architecture
-----
One of the primary systems in the Lambda architecture is called a worker. It's where AWS provisions a secure environment and enables the customer code execution.

Mesrobian explained that what the worker does is create and manage a collection of sandboxes and set limits on those boxes, such as memory and CPU available for function execution.

The worker downloads the customer code, announces it for execution, and also manages multiple language runtimes. The worker additionally executes the customer code through initialization and invocation, and finally it manages agents for monitoring and operational controls like AWS CloudWatch.

In order to help promote more isolation and security, AWS created the open-source Firecracker project, which provides a lightweight hypervisor isolation layer around Lambda functions.

At the top of the logical view of a worker host is customer code, which is what Lambda runs for its customers. Mesrobian commented that Lambda supports a number of languages and different runtimes including node, Python, Java, C# and more. Underneath the runtime is a sandbox that hosts the runtime, and underneath that is a guest operating system running Amazon Linux.

Underneath the guest operating system is a hypervisor and host operating system that the hypervisor runs in. And finally, AWS has the physical system hardware on which it all runs.

Underneath the guest operating system is a hypervisor and host operating system that the hypervisor runs in. And finally, AWS has the physical system hardware on which it all runs.

"So we have many accounts, each with their own micro VM running a single function," Mesrobian said. "With this architecture, we're able to run as many functions as we can provision on a worker and these functions can be from a single or multiple accounts."

AWS Lambda is optimized on the AWS infrastructure for maximum utilization. Mesrobian said Lambda gathers a variety of workloads to drive higher utilization rates.

"The most efficient placement strategy is to pick the workloads that pack well together and minimize contention," she said. "So it's all about putting the workloads where we can get optimum hardware utilization."

## useful url

https://www.quora.com/How-does-AWS-Lambda-internally-deploy-the-code-onto-the-servers-that-execute-it#

Questions: `how aws lambda works internally`

https://www.serverless.com/aws-lambda/

https://searchapparchitecture.techtarget.com/feature/Experts-explain-how-AWS-Lambda-works-internally

This strategy uses AWS Lambda to run microservices, and uses API Gateway's custom domain configuration to properly map and direct those microservices across the connected systems. AWS also provides tools that help with load balancing and CI/CD pipeline reliability.

![](figs/itops-cicd_pipeline_desktop.png)

This example CI/CD pipeline covers code development and delivery and a sampling of tests that help ensure releases are production-ready. 

https://searchaws.techtarget.com/blog/AWS-Cloud-Cover/AWS-month-in-review-An-AWS-reInvent-recap-of-overlooked-roll-outs

Serverless
-----
Provisioned Concurrency for AWS Lambda

This is a feature that keeps Lambda functions warm, meaning ready to execute. As serverless grows in popularity, AWS has looked to improve Lambda performance. Provisioned Concurrency will cut function cold starts, and costs \$0.015 per GB-hour for the amount of concurrency you provision and \$0.035 per GB-hour for the time your code is executed.

EKS on Fargate

AWS adds another option to deploy Kubernetes on AWS with this capability — albeit after a lengthy delay. ==First announced at re:Invent 2017==, Amazon Elastic Kubernetes Service (EKS) can now run Kubernetes pods on ==AWS Fargate==, Amazon’s serverless compute engine for containers. This is all handled in the EKS console rather than provisioning Kubernetes clusters on EC2.

Fargate Spot

This is AWS’ serverless version of ==EC2 Spot== Instances. Fargate Spot offers spare compute capacity at a discounted rate for Amazon Elastic Container Service tasks. These tasks can be interrupted when AWS needs that capacity back, so don’t use this option for mission-critical tasks.

|hacker inside|
----
|https://hackernoon.com/lambda-internals-exploring-aws-lambda-462f05f74076#931f|
|https://epsagon.com/blog/lambda-internals-part-two/|
|https://github.com/epsagon/lambda-internals|

https://docs.aws.amazon.com/lambda/latest/dg/welcome.html

https://aws.amazon.com/serverless/

https://aws.amazon.com/serverless/serverlessrepo/

https://aws.amazon.com/lambda/

https://serverlessrepo.aws.amazon.com/applications

https://www.protego.io/serverless-observability-podcast/

https://www.protego.io/the-serverless-show-uc-berkeley-on-the-rise-of-serverless-computing/

https://www.hpcwire.com/2019/02/13/uc-berkeley-paper-heralds-rise-of-serverless-computing-in-the-cloud-do-you-agree/

https://jaxenter.com/3-experts-2019-microservices-153012.html

https://medium.com/zappos-engineering/lambda-architecture-in-aws-79c5fc06ca4a

https://aws.amazon.com/blogs/architecture/understanding-the-different-ways-to-invoke-lambda-functions/

https://aws.amazon.com/blogs/architecture/top-10-architecture-blog-posts-of-2019/

https://www.zhihu.com/question/29490143

作者：Ye Huang
链接：https://www.zhihu.com/question/29490143/answer/257670332
来源：知乎
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。

这是对AWS无服务器构架的一个实践：
- 数据库 - DynamoDB
- 文件存储 - S3 // 前端 Web 资源存储：Amazon S3
- 身份验证 - Amazon IAM、Amazon Cognito
- 核心计算 - Lambda（包括数据库CRUD，文件池CRUD，GIS地理服务等）（编程模型 node.js、java、python）
- 服务发布 - API Gateway // 前后端 REST
- 域名管理 - Route 53
- 网站托管 - 代码包储存在S3，用CloudFront加速和保护（CDN, HTTPS, HTTP/2等），SSL来自Certificate Manager。
 
总结了一些使用感受如下：
- 无服务器构架很适合某些用户界面驱动（UI-driven）或者事件驱动（Event-driven或Message-driven）的应用。至于哪些以及如何决策，我觉得专门写一篇文章讨论都没问题。不过如果你要开发类似应用，无服务器构架是一个选项。上面demo就是本身需求与构架特色非常契合的例子。
- 在FaaS（Function as a Service）以前，无服务器构架已经存在很久了，那些第三方BaaS（Backend as a Service），比如Auth0、Firebase就是基于Serverless, 只是FaaS提供了一个方式让你可以更深入的操控后端代码。并且每个FaaS服务会被单独部署在一个无状态容器中（容器间没有关联，服务间没有依赖）被事件激活，一旦结束，当前实例就会关闭。adrian cockcroft 有一个很形象的描述：如果你的PaaS可以在20ms内激活一个实例，并且运行半秒后关闭，就可以称为serverless。这些特性能做什么就给你很大想象空间了。前面提到它很适合事件驱动的场景，原因就是事物的天然属性，事情不会旅行，只会发生，一件事又往往触发许多别的事，之后便产生了结果，结果一旦出现，事件就成历史，无需再监控和操作。由此可以看到用FaaS处理异步事件是非常恰当的（但注意，不是所有事件都适用，比如需要庞大计算资源和长时间等待的复杂任务就不合适。目前对云端空间大数据流的处理依旧建议采用传统方式，比如Apache Spark，Apache Kafka和诸如PostGIS的空间数据库结合的方案）。
- 和传统的容器相比，无服务器FaaS最大特色是无需维护后端构架，并且自动缩放，按需分配。举个例子，传统容器就像能装10公斤米的袋子，假设现在有52公斤米要装，你得买6个袋子，虽然浪费了8公斤的空间，也可以接受。但无服务器构架可以形容为米粒级别的袋子，52公斤有多少颗米，就给你多少袋子，几乎不浪费一点资源。这对软件开发商很有吸引，不仅精确控制资源需求，而且一旦任务完成就关闭服务，不再产生多余花销。从某种程度看，是达成用户和开发商的双赢。对于容器，目前还没有这种级别的解决办法，当然如Kubernetes提出的Horizontal Pod Autoscaling是发展趋势。关于其他优势，就不讨论了，可以去看看别人的讨论（JustServerless/awesome-serverless，anaibol/awesome-serverless）。
- 无服务器FaaS构架的缺点和它的优点一样突出，比如（1）第三方厂商的系统无法控制，对方收费策略变更，进行无法预测的构架升级之类也不无可能（真实案例，有个大公司A在没提前通报下游公司B的情况下，直接砍掉某个企业级产品，到全面停产的前一天才通知B，导致B权衡之下在公司内部停用所有A的企业级产品，转投另一家供应商C），而且由于供应商要考量所有用户的需求，就不可能给你最大的灵活度。（2）FaaS服务与供应商深度耦合。代码如果想迁移到不同的无服务器FaaS厂商，需要大量的改动重构。（3）安全性受到威胁而且很难优化服务器，不可能像私有云那样实施全面的安全策略和优化措施。（4）目前执行的函数数量受到限制（不超过1000个），每个函数的运行时间受到限制（不高于5分钟），函数的启动会延迟（比如遇到用JVM实现的实例）。（5）虽然写单元测试很简单因为本身就是函数接口，但基于第三方平台写集成测试很难，比如难道我所有集成测试都是基于第三方服务（如数据库）？这会导致如场景无法控制，费用增高，没法在本地离线测试系统等问题。（6）由于很难调用和集成其他私有资源或服务，包括前面提到的安全性和系统优化的灵活度，导致面向企业的产品很大程度不会选择这种构架。

-----------------
###  Serverless application use cases

Build virtually any type of application or backend service using a serverless architecture. Below are a couple of use cases:


Web applications and backends
-----------
You can build serverless web applications and backends using AWS Lambda, Amazon API Gateway, Amazon S3, and Amazon DynamoDB to handle web, mobile, Internet of Things (IoT), and chatbot requests.

You can build serverless backends using AWS Lambda to handle web, mobile, Internet of Things (IoT), and 3rd party API requests. Take advantage of Lambda’s consistent performance controls, such as multiple memory configurations and Provisioned Concurrency, for building latency-sensitive applications at any scale.

Example: Weather application // Web applications

> By combining AWS Lambda with other AWS services, developers can build powerful web applications that automatically scale up and down and run in a highly available configuration across multiple data centers – with zero administrative effort required for scalability, back-ups or multi-data center redundancy.

![](figs/eg1.png)

Reference Architecture: [Github link](https://github.com/aws-samples/lambda-refarch-webapp)

Example: Mobile backend for social media app //Mobile backends

> AWS Lambda makes it easy to create rich, personalized app experiences. You can build backends using AWS Lambda and Amazon API Gateway to authenticate and process API requests. Use AWS Amplify to easily integrate your backend with your iOS, Android, Web, and React Native frontends.

![](figs/eg2.png)

Reference Architecture: [Github link](https://github.com/aws-samples/lambda-refarch-mobilebackend)

==Bustle runs a serverless backend for its Bustle iOS app and websites using AWS Lambda and Amazon API Gateway. Serverless architectures allow Bustle to never have to deal with infrastructure management, so every engineer can focus on building out new features and innovating.== [Read the case study](https://aws.amazon.com/solutions/case-studies/bustle/) 

> With AWS Lambda, we eliminate the need to worry about operations. We just write code, deploy it, and it scales infinitely; no one really has to deal with infrastructure management."

Example: IoT backends

> You can build serverless backends using AWS Lambda to handle web, mobile, Internet of Things (IoT), and 3rd party API requests.

![](figs/eg6.png)

Reference Architecture: [Github link](https://github.com/aws-samples/lambda-refarch-iotbackend)

Data processing
--------------------
You can build a variety of real-time data processing systems using AWS Lambda, Amazon Kinesis, Amazon S3, and Amazon DynamoDB.

You can use AWS Lambda to execute code ==in response to triggers such as changes in data==, shifts in system state, or actions by users. ==Lambda can be directly triggered by AWS services such as S3, DynamoDB, Kinesis, SNS, and CloudWatch, or it can be orchestrated into workflows by AWS Step Functions.== This allows you to build a variety of real-time serverless data processing systems.

Example: Image Thumbnail Creation // Real-time file processing

> You can use Amazon S3 to trigger AWS Lambda to process data immediately after an upload. For example, you can use Lambda to thumbnail images, transcode videos, index files, process logs, validate content, and aggregate and filter data in real-time.

![](figs/eg3.png)

Reference architecture: [Github link](https://github.com/aws-samples/lambda-refarch-fileprocessing)

==Square Enix uses AWS Lambda to run image processing for its massively multiplayer online game. With Lambda, it was able to reliably handle spikes of up to 30 times normal traffic. It also lowered the time required for image processing from several hours to just over 10 seconds, and it reduced infrastructure and operational costs.== [Read the case study](https://aws.amazon.com/solutions/case-studies/square-enix/)

Example: Analysis of streaming social media data // Real-time stream processing

> You can use AWS Lambda and Amazon Kinesis to process real-time streaming data for application activity tracking, transaction order processing, click stream analysis, data cleansing, metrics generation, log filtering, indexing, social media analysis, and IoT device data telemetry and metering.

![](figs/eg4.png)

Reference architecture: [Github link](https://github.com/aws-samples/lambda-refarch-streamprocessing)

==Thomson Reuters uses a serverless architecture to process up to 4,000 events per second for its usage analytics service. The service reliably handles spikes of twice its normal traffic and has high durability. The company deployed the service into production in only five months using AWS.== [Read the case study](https://aws.amazon.com/solutions/case-studies/thomson-reuters/)

Example: Extract, transform, load

> You can use AWS Lambda to perform data validation, filtering, sorting, or other transformations for every data change in a DynamoDB table and load the transformed data to another data store.

![](figs/eg5.png)


---------------------------
和serverless无关，但和我的专业有关，哈哈哈
[arm](https://aws.amazon.com/solutions/case-studies/arm-case-study/)

---------------------
## AWS Lambda

AWS Lambda lets you run code ==without provisioning or managing servers.== You pay only for the compute time you consume.

With Lambda, you can run code for virtually any type of application or backend service - all with zero administration. Just upload your code and ==Lambda takes care of everything required to run and scale your code with high availability==. **You can set up your code to automatically trigger from other AWS services or call it directly from any web or mobile app.**

You can use AWS Lambda to run your code in response to events, such as changes to data in an Amazon S3 bucket or an Amazon DynamoDB table; to run your code in response to HTTP requests using Amazon API Gateway; or invoke your code using API calls made using AWS SDKs. ==With these capabilities, you can use Lambda to easily build data processing triggers for AWS services like Amazon S3 and Amazon DynamoDB, process streaming data stored in Kinesis, or create your own back end that operates at AWS scale, performance, and security.==

`You can also build serverless applications composed of functions that are triggered by events and automatically deploy them using CodePipeline and AWS CodeBuild.` For more information, see AWS Lambda applications.

When using AWS Lambda, you are responsible only for your code. `AWS Lambda manages the compute fleet that offers a balance of memory, CPU, network, and other resources. How ???` ==This is in exchange for flexibility, which means you cannot log in to compute instances, or customize the operating system on provided runtimes.== These constraints enable AWS Lambda to perform operational and administrative activities on your behalf, `including provisioning capacity, monitoring fleet health, applying security patches, deploying your code, and monitoring and logging your Lambda functions.`

If you need to manage your own compute resources, Amazon Web Services also offers other compute services to meet your needs.

- `Amazon Elastic Compute Cloud (Amazon EC2) service` offers flexibility and a wide range of EC2 instance types to choose from. It gives you the option to customize operating systems, network and security settings, and the entire software stack, but you are responsible for provisioning capacity, monitoring fleet health and performance, and using Availability Zones for fault tolerance.

- `Elastic Beanstalk` offers an easy-to-use service for deploying and scaling applications onto Amazon EC2 in which you retain ownership and full control over the underlying EC2 instances.

Create an AWS Account. `---` As a best practice, you should also create an AWS Identity and Access Management (IAM) user with administrator permissions and use that for all work that does not require root credentials. Create a password for console access, and access keys to use command line tools. See Creating your first IAM admin user and group in the IAM User Guide for instructions. `---` You can author functions in the Lambda console—or with an IDE toolkit, command line tools, or SDKs. The Lambda console provides a code editor for noncompiled languages that lets you modify and test code quickly. The AWS CLI gives you direct access to the Lambda API for advanced configuration and automation use cases.

You then verify execution results, including the logs that your Lambda function created and various `CloudWatch` metrics.

Lambda creates a `Node.js function` and an execution role that grants the function permission to upload logs. ==Lambda assumes the execution role when you invoke your function==, and uses it to create credentials for the AWS SDK and to read data from event sources.

AWS Lambda executes your function on your behalf. The `handler` in your Lambda function receives and then processes the sample event.

### AWS Lambda concepts

Function

A function is a resource that you can invoke to run your code in AWS Lambda. A function has code that processes events, and a runtime that passes requests and responses between Lambda and the function code. You provide the code, and you can use the provided runtimes or create your own.

Runtime

Lambda runtimes allow functions in different languages to run in the same base execution environment. You configure your function to use a runtime that matches your programming language. The runtime sits in between the Lambda service and your function code, relaying invocation events, context information, and responses between the two. You can use runtimes provided by Lambda, or build your own.

Event

An event is a JSON formatted document that contains data for a function to process. The Lambda runtime converts the event to an object and passes it to your function code. When you invoke a function, you determine the structure and contents of the event.

```
{
  "TemperatureK": 281,
  "WindKmh": -3,
  "HumidityPct": 0.55,
  "PressureHPa": 1020
}
```
```
{
  "Records": [
    {
      "Sns": {
        "Timestamp": "2019-01-02T12:45:07.000Z",
        "Signature": "tcc6faL2yUC6dgZdmrwh1Y4cGa/ebXEkAi6RibDsvpi+tE/1+82j...65r==",
        "MessageId": "95df01b4-ee98-5cb9-9903-4c221d41eb5e",
        "Message": "Hello from SNS!",
        ...
```

Concurrency

Concurrency is the number of requests that your function is serving at any given time. When your function is invoked, Lambda provisions an instance of it to process the event. When the function code finishes running, it can handle another request. If the function is invoked again while a request is still being processed, another instance is provisioned, increasing the function's concurrency.

Concurrency is subject to limits at the region level. You can also configure individual functions to limit their concurrency, or to ensure that they can reach a specific level of concurrency. 

Trigger

A trigger is a resource or configuration that invokes a Lambda function. ==This includes AWS services that can be configured to invoke a function, applications that you develop, and event source mappings. An event source mapping is a resource in Lambda that reads items from a stream or queue and invokes a function.==

Benefits:
- NO SERVERS TO MANAGE 
AWS Lambda automatically runs your code without requiring you to provision or manage servers. Just write the code and upload it to Lambda.
- CONTINUOUS SCALING 
AWS Lambda automatically scales your application by running code in response to each trigger. Your code runs in parallel and processes each trigger individually, scaling precisely with the size of the workload.
- SUBSECOND METERING
With AWS Lambda, you are charged for every 100ms your code executes and the number of times your code is triggered. You pay only for the compute time you consume. 
- CONSISTENT PERFORMANCE
With AWS Lambda, you can optimize your code execution time by choosing the right memory size for your function. You can also enable Provisioned Concurrency to keep your functions initialized and hyper-ready to respond within double digit milliseconds.

Asynchronous Invocation Settings Chapter: Invoking functions
----
![](figs/features-destinations.png)

Several AWS services, such as Amazon S3 and Amazon SNS, invoke functions asynchronously to process events. With new options in Lambda for asynchronous invocation, you can customize retry behavior. You can configure your function to send invocation records to a queue, topic, function, or event bus.

Concurrency Controls Chapter: Managing functions
----
![](figs/features-scaling-provisioned-auto.png)

Use concurrency controls in Lambda to ensure that your functions can scale up quickly without fluctuations in latency. Reserved concurrency splits the available concurrency in a Region into pools that are assigned to individual functions. A new control, provisioned concurrency, allocates concurrency before demand increases. Provisioned concurrency integrates with Application Auto Scaling to manage provisioned concurrency on a schedule or based on utilization.

Security in AWS Lambda
----
A new chapter on security provides an overview of cloud security concepts that are relevant to Lambda functions and applications. For details on Lambda features that support security best practices, see the Data Protection and Resilience topics.

## Top 10 Architecture Blog Posts of 2019

### #10: [How to Architect APIs for Scale and Security //  REST vs GraphQL APIs](https://aws.amazon.com/blogs/architecture/how-to-architect-apis-for-scale-and-security/)

This post was the first in a series that focused on best practices and concepts you should be familiar with when you architect APIs for your applications.

We’ll kick this first post off with a comparison between REST and ==GraphQL== API architectures.

Developers have been creating RESTful APIs for a long time, typically using HTTP methods, such as GET, POST, DELETE to perform operations against the API. Amazon API Gateway is designed to make it easy for developers to create APIs at any scale ==without managing any servers. API Gateway will handle all of the heavy lifting needed including traffic management, security, monitoring, and version/environment management.==

[Amazon API Gateway](https://aws.amazon.com/api-gateway/) 开发者不需要管理任何服务器。API Gateway能够处理所有的脏活累活，包括：交通流量管理、安全、监视、和版本环境的管理。

![](figs/APIGateway.jpg)

### #9: [From One to Many: Evolving VPC Guidance](https://aws.amazon.com/blogs/architecture/one-to-many-evolving-vpc-design/)

Since its inception, the ==Amazon Virtual Private Cloud (VPC)== has acted as the embodiment of security and privacy for customers who are looking to run their applications in a controlled, private, secure, and isolated environment.

### #8: [Things to Consider When You Build REST APIs with Amazon API Gateway](https://aws.amazon.com/blogs/architecture/things-to-consider-when-you-build-rest-apis-with-amazon-api-gateway/)

This post will dive deeper into the things an API architect or developer should consider when building REST APIs with Amazon API Gateway.

Request Rate (a.k.a. “TPS”)
Request rate is the first thing you should consider when designing REST APIs. By default, API Gateway allows for up to 10,000 requests per second. You should use the built in Amazon CloudWatch metrics to review how your API is being used. The Count metric in particular can help you review the total number of API requests in a given period.

It’s important to understand the actual request rate that your architecture is capable of supporting. For example, consider this architecture:

![](figs/restAPI-1.jpg)

This API accepts GET requests to retrieve a user’s cart by using a Lambda function to perform SQL queries against a relational database managed in RDS.  If you receive a large burst of traffic, both API Gateway and Lambda will scale in response to the traffic. However, relational databases typically have limited memory/cpu capacity and will quickly exhaust the total number of connections.

As an API architect, you should design your APIs to protect your down stream applications.  You can start by defining API Keys and requiring your clients to deliver a key with incoming requests. This lets you track each application or client who is consuming your API.  This also lets you create Usage Plans and throttle your clients according to the plan you define.  For example, you if you know your architecture is capable of of sustaining 200 requests per second, you should define a Usage plan that sets a rate of 200 RPS and optionally configure a quota to allow a certain number of requests by day, week, or month.

Additionally, API Gateway lets you define throttling settings for the whole stage or per method. If you know that a GET operation is less resource intensive than a POST operation you can override the stage settings and set different throttling settings for each resource.

The example above describes a synchronous, tightly coupled architecture where the request must wait for a response from the backend integration (RDS in this case). This results in system scaling characteristics that are the lowest common denominator of all components. Instead, you should look for opportunities to design an asynchronous, loosely coupled architecture. A decoupled architecture separates the data ingestion from the data processing and allows you to scale each system separately. Consider this new architecture:

![](figs/restAPI-2.jpg)

This architecture enables ingestion of orders directly into a highly scalable and durable data store such as ==Amazon Simple Queue Service (SQS)==.  Your backend can process these orders at any speed that is suitable for your business requirements and system ability.  Most importantly,  the health of the backend processing system does not impact your ability to continue accepting orders.

**Security**

Security with API Gateway falls into three major buckets, and I’ll outline them below. Remember, you should enable all three options to combine multiple layers of security.

- Option 1 (Application Firewall)
- Option 2 (Resource Policy)
- Option 3 (AuthZ)

很遗憾，为了工作量和篇幅，我们忽略这一部分。

==I hope you’ve enjoyed this post and our next post will cover GraphQL API architectures with AWS AppSync.==

### #7: [How to Design Your Serverless Apps for Massive Scale](https://aws.amazon.com/blogs/architecture/how-to-design-your-serverless-apps-for-massive-scale/)

**Scaling Considerations**

In general, developers in a “serverful” world need to be worried about how many total requests can be served throughout the day, week, or month, and how quickly their system can scale. As you move into the serverless world, the most important question you should understand becomes: “What is the concurrency that your system is designed to handle?”

The AWS Serverless platform allows you to scale very quickly in response to demand. Below is an example of a serverless design that is fully synchronous throughout the application. During periods of extremely high demand, Amazon API Gateway and AWS Lambda will scale in response to your incoming load. This design places extremely high load on your backend relational database because Lambda can easily scale from thousands to tens of thousands of concurrent requests. In most cases, your relational databases are not designed to accept the same number of concurrent connections.

![](figs/fully_synchronous_design.jpg)

==This design risks bottlenecks at your relational database and may cause service outages. This design also risks data loss due to throttling or database connection exhaustion.==

**Cloud Native Design**

Instead, you should consider decoupling your architecture and moving to an asynchronous model. In this architecture, you use an intermediary service to buffer incoming requests, such as Amazon Kinesis or Amazon Simple Queue Service (SQS). You can configure Kinesis or SQS as out of the box event sources for Lambda. In design below, AWS will automatically poll your Kinesis stream or SQS resource for new records and deliver them to your Lambda functions. You can control the batch size per delivery and further place throttles on a per Lambda function basis.

![](figs/Cloud_Native_Design.jpg)

This design allows you to accept extremely high volume of requests, store the requests in a durable datastore, and process them at the speed which your system can handle.

**Conclusion**

Serverless computing allows you to scale much quicker than with server-based applications, but that means application architects should always consider the effects of scaling to your downstream services. Always keep in mind cost, speed, and reliability when you’re building your serverless applications.

### #3: [Understanding the Different Ways to Invoke Lambda Functions](https://aws.amazon.com/blogs/architecture/understanding-the-different-ways-to-invoke-lambda-functions/)

![](figs/3-ways.png)

- Synchronous Invokes
- Asynchronous Invokes
- Poll-Based Invokes

### #1: [10 Things Serverless Architects Should Know](https://aws.amazon.com/blogs/architecture/ten-things-serverless-architects-should-know/)

1. API and Microservices Design
2. Event-driven Architectures and Asynchronous Messaging Patterns
3. Workflow Orchestration in a Distributed, Microservices Environment
4. Lambda Computing Environment and Programming Model
5. Serverless Deployment Automation and CI/CD Patterns
6. Serverless Identity Management, Authentication, and Authorization
7. End-to-End Security Techniques
8. Application Observability with Comprehensive Logging, Metrics, and Tracing
9. Ensuring Your Application is Well-Architected 
10. Continuing your Learning as Serverless Computing Continues to Evolve

## Specification

Each AWS Lambda instance is a container created from Amazon Linux AMIs (a Linux distribution related to RHEL) with 128-3008 MB of RAM (in 64 MB increments), 512 MB of ephemeral storage (available in /tmp, the data lasts only for the duration of the instance, it gets discarded after all the tasks running in the instance complete) and a configurable execution time from 1 to 900 seconds. The instances are neither started nor controlled directly. Instead, a package containing the required tasks has to be created and uploaded (usually) to an S3 bucket and AWS is instructed (via Amazon Kinesis, DynamoDB or SQS) to run it when an event is triggered. Each such execution is run in a new environment so access to the execution context of previous and subsequent runs is not possible. This essentially makes the instances stateless, all the incoming and outgoing data needs to be stored by external means (usually via S3 or DynamoDB, inbound connections to the instances is disabled). The maximum compressed size of a Lambda package is 50 MB with the maximum uncompressed size being 250 MB. 


## 运行机理

Programming model

Authoring specifics vary between runtimes, but all runtimes share a common programming model that defines the interface between your code and the runtime code. You tell the runtime which method to run by defining a handler in the function configuration, and the runtime runs that method. The runtime passes in objects to the handler that contain the invocation event and the context, such as the function name and request ID.

When the handler finishes processing the first event, the runtime sends it another. The function's class stays in memory, so clients and variables that are declared outside of the handler method in initialization code can be reused. To save processing time on subsequent events, create reusable resources like AWS SDK clients during initialization. Once initialized, each instance of your function can process thousands of requests. 

----------
## other

摘要：2018年接近尾声，这一年，微软收购了Github，IBM收购了红帽，华为推出全栈专属FCS，Oracle努力从数据库身上寻求云业务的增长点。从现在看未来，这些行为预示着哪些市场变化呢？

本文整合了三位技术专家对于2019年技术发展的观点解读，涉及技术开发、人工智能、云计算等方面。不难看出，微服务的兴起可能会影响用户对数据库的需求，编码需求日益增长，无服务器将进入增长期，而Kubernetes将会在经过一段下降期后趋于稳定！

DataStax的 Developer Relations 副总裁 Patrick McFadin

1、微服务和容器将影响数据库的发展

用户正在使用微服务开发新应用程序以及完成工作所需的特定组件，所有组件都必须依赖数据运行。我们可以考虑将容器作为一个选择，运行可以随时间存储数据的有状态容器实例，相比之下，显然从数据库中可以获取更多数据。2019年，一个重要趋势是了解数据库如何满足应用程序的特定需求，更重要的是在不需要重写应用程序的前提下满足这些需求。

2、用户逐渐开始清晰认知Kubernetes

对于Kubernetes，之前可能存在许多炒作，它确实提供了一个大规模管理容器的好方法，但是用户很快就可以发现它的缺点。未来一年将会发生两件事情：一是在问题实际发生时，Kubernetes并没有很好满足过高期望，用户可能会开始产生抵触；二是用户开始对Kubernetes和容器产生清晰认知，意识到这并不能解决所有问题。

3、 在混合、多云世界中的企业需求

越来越多的企业希望推出混合和多云应用，但也必须考虑这其中存在的数据问题。2019年，人们不再仅关注应用程序组件而是考虑更广泛的应用程序基础架构。数据方面的问题将成为混合云、多云架构的一大难点，特别是如果想避免与某个云提供商绑定。

4、人工智能和机器学习对数据的影响

似乎，每个人、每家企业都想做人工智能。未来一年，云供应商将增加各种工具和集成以消除机器学习的复杂性。因此，更多实现建立在对云API服务的正确调用之上，而不是构建在算法和基础架构之上。

5、开源社区与云提供商的关系

2018年，云服务与开源项目之间的关系被进一步激化，明年应该可以看到开源基金会对此的回应以及云供应商在使用开源项目上的转变。通常作为回报，大型云提供商会加大对开源项目的贡献和推广力度。如果贡献力度下降，较小的开源项目将开始受到影响。

Sumo Logic联合创始人兼CTO Christian Beedgen

1、编程将成为一项更普及的技能

如今，自动化仍然是大规模成功的关键。随着云计算的崛起，开发人员将会发现新的实践点——敏捷，通过自动化实现敏捷，实时扩展需要自动化，扩缩容需要自动化…这些都需要程序员进行改进。

Sumo Logic产品营销总监 Benoton

1、无服务器将进入增长期，Kubernetes可能面临减速

Benoton 认为，无服务器将成为未来一年的主流，两类人非常适合应用无服务器：容器当前提供的计算无法满足需求的人和不想承担容器化开销的人。这种趋势始于2018年，其中AWS Lambda的采用率从2017年的24％增长到2018年的29％，预计这一数字将在2019年继续飙升。

容器化已接近炒作周期的顶端，很快就会陷入众所周知的幻灭低谷，但由于媒体的关注以及其提供托管或本地K8s服务，或将继续保持稳定。也就是说，随着越来越多的企业倾向于无服务器，容器的采用会在预期内有所下降。
————————————————
版权声明：本文为CSDN博主「weixin_34210740」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/weixin_34210740/java/article/details/89179226