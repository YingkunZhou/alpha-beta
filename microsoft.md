# Microsoft
[What is serverless computing?](https://azure.microsoft.com/en-us/overview/serverless-computing/)
## Benefits of serverless computing

### Increase developer velocity

* Reduce the time spent on tasks that are non-core to the business by freeing developers from infrastructure provisioning and management. Build and deploy faster using developer-friendly APIs, low-code/no-code services, and ready-to-use machine learning and cognitive models.

### Boost team performance

* Improve team agility and performance by using a fully managed platform to build, deploy, and operate applications. Build for any application pattern and environment—hybrid, cloud, and edge. Proactively manage applications with intelligent monitoring and analysis tools.

### Improve organizational impact

* Accelerate time to market with Azure serverless solutions that help your organization clear the path to innovation and new revenue opportunities. Reduce your infrastructure total cost of ownership and minimize risk with intelligent security management and advanced threat protection.

### No infrastructure management

* Using fully managed services enables developers to avoid administrative tasks and focus on core business logic. With a serverless platform, you simply deploy your code, and it runs with high availability.

### Dynamic scalability

* With serverless computing, the infrastructure dynamically scales up and down within seconds to match the demands of any workload.

### Faster time to market

* Serverless applications reduce the operations dependencies on each development cycle, increasing development teams’ agility to deliver more functionality in less time.

### More efficient use of resources

* Shifting to serverless technologies helps organizations reduce TCO and reallocate resources to accelerate the pace of innovation.


## Serverless application patterns

### Serverless functions

Serverless functions accelerate development by using an event-driven model, with triggers that automatically execute code to respond to events and bindings to seamlessly integrate additional services. A pay-per-execution model with sub-second billing charges only for the time and resources it takes to execute the code.

Azure Functions is an event driven, compute-on-demand experience that extends the existing Azure application platform with capabilities to implement code triggered by events occurring in virtually any Azure or 3rd party service as well as on-premises systems. Azure Functions allows developers to take action by connecting to data sources or messaging solutions, thus making it easy to process and react to events. Azure Functions scale based on demand and you pay only for the resources you consume.

Azure Functions allows you to run small pieces of code (called "functions") without worrying about application infrastructure. With Azure Functions, the cloud infrastructure provides all the up-to-date servers you need to keep your application running at scale.

A function is "triggered" by a specific type of event. Supported triggers include responding to changes in data, responding to messages, running on a schedule, or as the result of an HTTP request.

While you can always code directly against a myriad of services, integrating with other services is streamlined by using bindings. Bindings give you declarative access to a wide variety of Azure and third-party services.

#### Features
* `Serverless applications`: Functions allow you to develop serverless applications on Microsoft Azure.

* `Choice of language`: Write functions using your choice of C#, Java, JavaScript, Python, and PowerShell.

* `Pay-per-use pricing model`: Pay only for the time spent running your code. See the Consumption hosting plan option in the pricing section.

* `Bring your own dependencies`: Functions supports NuGet and NPM, giving you access to your favorite libraries.

* `Integrated security`: Protect HTTP-triggered functions with OAuth providers such as Azure Active Directory, Facebook, Google, Twitter, and Microsoft Account.

* `Simplified integration`: Easily integrate with Azure services and software-as-a-service (SaaS) offerings.

* `Flexible development`: Set up continuous integration and deploy your code through GitHub, Azure DevOps Services, and other supported development tools.

* `Stateful serverless architecture`: Orchestrate serverless applications with Durable Functions.

* `Open-source`: The Functions runtime is open-source and available on GitHub.


#### Do with Functions

Functions is a great solution for processing bulk data, integrating systems, working with the internet-of-things (IoT), and building simple APIs and micro-services.

* `HTTP`: Run code based on HTTP requests

* `Timer`: Schedule code to run at predefined times

* `Azure Cosmos DB`: Process new and modified Azure Cosmos DB documents

* `Blob storage`: Process new and modified Azure Storage blobs

* `Queue storage`: Respond to Azure Storage queue messages

* `Event Grid`: Respond to Azure Event Grid events via subscriptions and filters

* `Event Hub`: Respond to high-volumes of Azure Event Hub events

* `Service Bus Queue`: Connect to other Azure or on-premises services by responding Service Bus queue messages

* `Service Bus Topic`: Connect other Azure services or on-premises services by responding to Service Bus topic messages

#### Durable Functions

* Durable Functions is an extension of Azure Functions that lets you write stateful functions in a serverless compute environment. The extension lets you define stateful workflows by writing orchestrator functions and stateful entities by writing entity functions using the Azure Functions programming model. Behind the scenes, the extension manages state, checkpoints, and restarts for you, allowing you to focus on your business logic.

* The primary use case for Durable Functions is simplifying complex, stateful coordination requirements in serverless applications. The following sections describe typical application patterns that can benefit from Durable Functions:
    * Function chaining
    * Fan-out/fan-in
    * Async HTTP APIs
    * Monitoring
    * Human interaction
    * Aggregator (stateful entities)

* Behind the scenes, the Durable Functions extension is built on top of the Durable Task Framework, an open-source library on GitHub that's used to build workflows in code. Like Azure Functions is the serverless evolution of Azure WebJobs, Durable Functions is the serverless evolution of the Durable Task Framework. Microsoft and other organizations use the Durable Task Framework extensively to automate mission-critical processes. It's a natural fit for the serverless Azure Functions environment.


### Serverless Kubernetes

Elastically provision pods inside container instances that start in seconds without the need to manage additional compute resources. Create serverless, Kubernetes-based applications using the orchestration capabilities of [Azure Kubernetes Service (AKS)](https://azure.microsoft.com/en-us/services/kubernetes-service/) and [AKS virtual nodes](https://azure.microsoft.com/en-us/blog/bringing-serverless-to-azure-kubernetes-service/), which are built on the open-source Virtual Kubelet project. Get the best of an event-driven approach by adding KEDA event-driven autoscaling to your AKS cluster. [KEDA](https://github.com/kedacore/keda) is an open-source component that enables containers to process events directly from event sources, and it provides the ability to scale to zero.
[一个使用AKS的例子](https://yq.aliyun.com/articles/727132)

### Serverless workflows

Integrate data and apps instead of writing complex glue code between disparate systems. Visually create serverless workflows with [Azure Logic Apps](https://azure.microsoft.com/en-us/services/logic-apps/) and use your own APIs, serverless functions, or out-of-the-box software as a service (SaaS) connectors, including Salesforce, Microsoft Office 365, and Dropbox.

### Serverless application environments
With a serverless application environment, both the back end and front end are hosted on fully managed services that handle scaling, security, and compliance requirements.

### Serverless API gateway
Publish, secure, transform, maintain, and monitor APIs with [Azure API Management](https://azure.microsoft.com/en-us/services/api-management/), a fully managed service that offers a usage model designed and implemented to be an organic fit for serverless applications.

## Serverless solution architectures

![alt text](figs/Microsoft Serverless Architectpng_Page1.png)

TODO


## Azure Data Lake Analytics

Azure Data Lake Analytics is an on-demand analytics job service that simplifies big data. Instead of deploying, configuring, and tuning hardware, you write queries to transform your data and extract valuable insights. The analytics service can handle jobs of any scale instantly by setting the dial for how much power you need. You only pay for your job when it is running, making it cost-effective.

### Dynamic scaling
Data Lake Analytics dynamically provisions resources and lets you do analytics on terabytes to petabytes of data. You pay only for the processing power used. As you increase or decrease the size of data stored or the amount of compute resources used, you don’t have to rewrite code.

### Develop faster, debug, and optimize smarter using familiar tools
Data Lake Analytics deep integrates with Visual Studio. You can use familiar tools to run, debug, and tune your code. Visualizations of your U-SQL jobs let you see how your code runs at scale, so you can easily identify performance bottlenecks and optimize costs.

### U-SQL: simple and familiar, powerful, and extensible
Data Lake Analytics includes U-SQL, a query language that extends the familiar, simple, declarative nature of SQL with the expressive power of C#. The U-SQL language uses the same distributed runtime that powers Microsoft's internal exabyte-scale data lake. SQL and .NET developers can now process and analyze their data with the skills they already have.

### Integrates seamlessly with your IT investments
Data Lake Analytics uses your existing IT investments for identity, management, and security. This approach simplifies data governance and makes it easy to extend your current data applications. Data Lake Analytics is integrated with Active Directory for user management and permissions and comes with built-in monitoring and auditing.

### Affordable and cost effective
Data Lake Analytics is a cost-effective solution for running big data workloads. You pay on a per-job basis when data is processed. No hardware, licenses, or service-specific support agreements are required. The system automatically scales up or down as the job starts and completes, so you never pay for more than what you need. 

### Works with all your Azure data
Data Lake Analytics works with Azure Data Lake Storage for the highest performance, throughput, and parallelization and works with Azure Storage blobs, Azure SQL Database, Azure Warehouse.
