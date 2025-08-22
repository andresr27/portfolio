# CV for Senior Devops Engineer
<figure>  <img src="public/images/header.png" alt="DevOps CV header."> </figure>

## Table of Contents

- [Technical Stack](#technical-stack)
    - [Operating Systems](#operating-systems)
    - [Cloud Platforms](#cloud-platforms)
    - [IaC and Configuration Management](#iac-and-configuration-management)
    - [Computing Clusters](#computing-clusters)
    - [CI/CD Automation](#cicd-automation)
    - [Monitoring Solutions](#monitoring-solutions)
    - [Databases](#databases)
    - [Programming Languages](#programming-languages)
    - [Data Analysis](#data-analysis)
    - [Product Development](#product-development)
    - [Software Frameworks](#software-frameworks)
    - [Other Libraries](#other-libraries)
    - [Security](#security)
- [Professional Experience](#professional-experience)
    - [DevOps Roles](#devops-roles)
    - [Developer Roles](#developer-roles)
    - [Site Operations](#site-operations)
- [Projects](#projects)
    - [DevOps Projects](#devops-projects)
        - [Windiffent Infrastructure Automation](#devops-engineer--windiffent)
        - [Upwave Multi-Region IaC](#devops-engineer--upwave)
        - [Netlabs Cloud Infrastructure](#devops-engineer--netlabs)
        - [Upwork Containerization](#devops-engineer--upwork)
        - [Antel ASVAC SRE](#sre-engineer-for-antel-asvac--netlabs)
        - [XN Brasil System Administration](#system-administrator-for-xn-brasil)
    - [Developer Projects](#developer-projects)
        - [BioIntellisense Data Pipelines](#python-full-stack-developer-for-biointellisense)
        - [Antel NDG Product Development](#product-developer-for-antel-ndg)
        - [Boxes IoT Development](#full-stack-developer-for-boxes)
- [Education](#education)
    - [Courses](#courses)
    - [Academic Studies](#academic-studies)
- [Public Speaking](#public-speaking)
- [Languages](#languages)
- [Interests](#interests)

---
    
## Stack

I have a dream stack it would be:

- Kubernetes for microservices and functions
- Terraform for IaaC
- CI/CD with GitHub Actions
- Opensearch for observability

That said, I am more than used to work with great variety of tools, too many to remember them all, some of them bellow.

### Operating Systems
- Ubuntu, Centos, Suse, Redhat, Debian, Windows.
### Clouds
- AWS, Google Cloud, Azure, VCloud Director.
### IaaC and Configuration Management
- Terraform, Ansible
### Computing Clusters
- Kubernetes, Swarm, Hadoop, MapReduce
### Automation for CI/CD
- Kubernetes, Docker, Git, Github-actions, Jenkins, Bitbucket pipelines
### Monitoring
- Opensearch, Grafana, Grafana Cloud, Datadog, Cloudwatch, Prometheus, Data Prepper, OTEL, Fluent-bit, Fluent-d, Logstash, Graylog, Syslog.
### Databases
- MySQL, MariaDB, SQLLite, InfluxDB, Postgres, DynamoDB, BigTable, Hive, Elasticsearch, Databricks, Superset, Metabase.
### Programming languages
- Python, Typescript, C, Assembler, Bash, Java, JavaScript, Latex, R.
### Data Analysis
- Opensearch, R, Elasticsearch, Kibana, Python, Matlab, Tableau, Excel.
### Product Development
- Agile, Jira, Project Requirements, Planning and Management.
### Software Frameworks
- Spring Boot, Flask, Jboss, Laravel, Kivy, Bootstrap, Express
### Other Libraries
- boto3, pandas, websocket, pyserial, ggplot2, refind, csv
### Security
- Apache WAFs, DB and OS hardening, HIDS for Kubernetes with Elasticsearch, TWIGS, AWS Well Architected Framework, Currently under CompTIA Security+ Training

## Experience

### DevOps

#### [2022–2024 DevOps Engineer and Cloud Infrastructure Manager, Windifferent, Montevideo, Uruguay.](https://www.windifferent.com/)
- My role involved managing AWS infrastructure and application deployments using Terraform, Kubernetes, Octopus, and the Atlassian stack. Later promoted to manager; I oversaw the data access process and network access policies.
- I managed, debugged, and troubleshot data platforms including:
    - Databricks and Kafka connectivity to different data sources.
    - Created a process to authorize access to data using roles.
- Managed data consumption tools like Superset and Metabase, migrating from ECS to Kubernetes.
- Managed CI/CD pipelines for CMA BE and FE and other microservices using Octopus, Bitbucket, and JFrog.
- Used OpenSearch and Grafana, and also worked with a centralized Datadog instance to monitor legacy assets.
- Managed the DBA team to perform:
    - Hardware upgrades, software updates, schema changes.
    - Enabled/disabled HA and replication.
    - Secured networks and implemented password rotation.
    - Minimized downtime during operations.
- Increased our IaC coverage significantly by:
    - Adding an EKS cluster and VPC to Terraform and managing most accounts.
    - Deploying and configuring an OpenSearch cluster using Terraform and Python.
    - Fixing broken code in Databricks installations, which had previously been applied manually.
    - Developing a process to automate those changes, though it wasn't fully adopted.
- Managed workflow through Jira and tracked work sources to optimize processes and increase capacity.
- Led the cloud infrastructure team in improving documentation and defining policies for user authorization and resource creation.
- Used Jira extensively to track project progress and team deliveries.

#### [2020–2022 DevOps Engineer, Upwave, Montevideo, Uruguay.](https://www.upwave.com/)
- Managed AWS infrastructure and application deployments using Terraform, Kubernetes, Jenkins, CodeBuild, and GitHub. Additional responsibilities included database management, security assessments, and internal documentation.
- Researched and documented Terraform best practices tailored to the company.
- Managed monitoring tools like Prometheus, Grafana, and CloudWatch.
- Extensive experience with log analysis using Elasticsearch/OpenSearch. Created TypeScript tools to automate OpenSearch configuration.
- Added SSM Inventory for terminal access and created Systems Manager Documents to automate server provisioning.
- Created reports and managed AWS services using Python and Boto3.
- Managed multiple EKS clusters using Terraform and `kubectl`.
- Used Kustomize to integrate NGINX controllers with VS and VSR configurations.
- Built new Terraform modules and workspaces using Terraform Cloud for multi-region deployments.
- Wrote DRY Terraform code for AWS services including EC2, Beanstalk, EKS, EMR, VPC, S3, CloudFront, Athena, SQS, and CloudWatch.
- Used Ansible to provision servers alongside Terraform.
- Managed and deployed Kubernetes clusters, including certificate handling, core services, node upgrades, and autoscaling.
- Built CI/CD pipelines with Jenkins and GitHub Actions.
- Addressed security issues like UI redressing and clickjacking, added DMARC protection, and ran infrastructure analysis using TWIGS and ACM certificates.

#### [2018–2019 Reliability Engineer, Netlabs, HG Offices, Montevideo, Uruguay.](https://www.netlabsglobal.io/)
- Part of the Site Reliability Engineering team, responsible for managing Linux production environments.
- Developed Business-as-a-Service solutions on VMware private cloud.
- Managed virtual infrastructure using vCloud Director and Ansible.
- Developed CI/CD pipelines using Jenkins and Git.
- Used Docker Swarm to deliver custom containers with Zabbix, ELK Stack, and HIDS for clients.
- Created a CMDB of virtual infrastructure and software using Ansible.
- Built hardened virtual machine templates and automation scripts; contributed to architecture design.
- Deployed critical updates to Java/JBoss applications across Ubuntu, Debian, RedHat, and CentOS.
- Maintained and updated technical documentation.
- Administered firewalls and load balancers using iptables, F5, and Fortinet.
- Delivered high-availability web services using Apache, NGINX, Keepalived, and HAProxy.
- Deployed and managed performance monitoring tools such as Zabbix, Elasticsearch, Kibana, and Grafana.
- Built data visualizations (e.g., choropleths) using the ELK stack with Beats and custom scripts.

#### [2017–2018 Reliability Engineer, Netlabs, HQ, Montevideo, Uruguay.](https://www.netlabsglobal.io/)
- Provided SRE services for several small clients.
- Deployed a responsive JS/PHP web application for São Paulo metro ticketing with PayPal integration.
- Managed virtual infrastructure in AWS.
- Set up Jira Service Desk and created Docker-based developer environments.
- Presented Redmine and ELK stack demos to clients.
- Delivered an HDInsight PaaS presentation using Microsoft Azure.
- Integrated Tableau Desktop with Hortonworks Hadoop using JDBC/ODBC for a major telecom provider.
- Acted as Level 3 System Administrator for Netgate Uruguay's email and hosting services.

### Developer

#### [2020 Python Full Stack Developer, BairesDev, Remote, Montevideo, Uruguay](https://www.biointellisense.com/).
- Ported Data Science algorithms from Python notebooks to production using GCP Cloud Functions and Pandas.
- Provided SRE services and helped deploy JS/PHP web apps.
- Worked for BioIntellisense on biomedical IoT projects.
- Modified Java libraries to accommodate expanded data inputs.
- Built data pipelines using protocol buffers and Bigtable.
- Wrote integration tests using `unittest` and `pytest`.
- Followed Agile practices using Jira and Bitbucket.

#### [2014–2019 Technical Leader, Boxes, Montevideo, Uruguay.](https://boxesdevices.com/)
- Developed interactive vending machines with engineers and suppliers.
- Authored technical documentation for grant applications.
- Led UI/UX redesign using Python/Kivy.
- Designed Raspberry Pi shields using Arduino Leonardo.
- Built a JavaScript/Java admin console with Bootstrap, deployed on AWS using Gradle.
- Developed Python clients for OpenVPN-based M2M communication.
- Replaced PyGame with Kivy to improve embedded UI performance.
- Awarded by ANII (National Research and Innovation Agency).
- As an entrepreneur I wanted to supply industrial-grade Linux machines as alternatives to proprietary PLC systems (ABB, Siemens, Phoenix Contact).
- PoC built of hybrid GPRS/Zigbee network using IMod devices from Techbase.

### Site Operations

#### [2014–2017 Data Center Technical Leader, IBM, Montevideo, Uruguay.](https://www.ibm.com/account/uy/es/)
- Managed physical assets and service contracts for IBM's data centers in Uruguay.
- Ensured operational compliance using Agile methods.
- Planned and executed infrastructure maintenance (UPS, generators, HVAC, panels, BMS, security, FDS).
- Reported site status to global/regional managers with the aim of achieving RL2 and RL3 compliance.
- Led infrastructure projects including equipment deployments and move-outs.

#### [2007–2014 Process Control Engineer, ISUSA, Ciudad del Plata, San José.](https://isusa.com.uy/)
- Ensured industrial communication and control systems functioned reliably in fertilizer and sulfuric acid plants.
- Built inventory and maintenance plans for all electrical equipment.
- Administered Windows servers for critical operations.
- Automated gas emissions reporting using Office macros and VBScript.
- Designed and deployed a control system for a new water treatment plant.
- Created SCADA interfaces using iFIX and Visual Basic.
- Upgraded WAN infrastructure to enable unified communications.
- Installed industrial radio links to improve site-wide networking.
- Implemented video-over-MPLS conferencing with LifeSize hardware.

#### Other
- In 2006, worked at the Municipality of Montevideo repairing and delivering computer hardware while finishing my Electrical Engineering degree.
- In 1999–2000, worked part-time at a Couche-Tard minimarket in Montreal, Canada, restocking and cleaning while attending college.

# Projects

## DevOps

### Senior DevOps Engineer @ Windiffent

This company was my biggest challenge yet. I begun as Senior DevOps engineer building a new monitoring system for applications
running in distributed K8s clusters (multiple clouds, more than 5 and not most known) and also a few thing run on Linux instances.

Provisioning of the cluster was straight forward with Kustomize, but Instance we had to use Ansible and AWX roles. I delivered that
and things changed I started helping people with Kafa cluster in K8s and also Databricks setups with Terraform on AWS, remembering it gives me the chills.

Then I was promoted to manager of DevOps and DBAs, but there is separate section for that. 
These are some other things I did: 
- Advanced IaC development using Terraform and Terragrunt.
- Managed Kubernetes clusters created Terraform and Ansible roles in AWS
- Deployed microservices and operators with Helm including Kafka, Prometheus, Superset, DataPrepper, Grafana Agent.
- Configured AWS services including: EKS, ECS, RDS, CloudFront, SQS, Openvpn, Opensearch, Lambda, SNS, Cloudwatch.
- Developed Ansible scripts to automate provisioning of EC2 instances for general purposes, bastions and reverse proxies.
- Managed applications logs with Opensearch.
- Monitored Kubernetes clusters using Prometheus and Grafana, OTEL and Data prepper.

Unfortunately, I don't have any code to share with you, as it was proprietary and deleted when I finished the job.

### Cloud infrastructure manager @ Windiffent

My goal was to increase reliability and optimized costs. My team managed AWS infrastructure and application deployments 
for several teams of the company.

The assets of the company was distributed across more than 10 AWS accounts for connected through different methods Peerings, Proxied connections, Internet VPN. 

Difference in how we should manage security, cloud architecture and monitoring led to the termination of my contract. 
Bellow more details on other tasks I performed:
- I oversaw the data access process and network access policies for AWS resources.
- Created a process to authorize access to data using roles and groups in Databricks.
- Managed data consumption tools like Superset and Metabase, migrating from ECS to Kubernetes.
- Created documentation and secured access to out Database.
- Proposed reference architecture to unify company assets and decrease the exposure surface.
- Plan migration
- Create Python Synthetic checker agent to log checks from different networks, ie: VPN, Internet (Whitelist), other accounts, other Orgs.
- Managed the DBA team to perform:
  - Hardware upgrades, software updates, schema changes.
  - Enabled/disabled HA and replication.
  - Secured networks and implemented password rotation. 
  - Minimized downtime during operations, by using multiAZ and proper DNS routing
- Managed workflow through Jira and tracked work sources to optimize processes and increase capacity.
- Led the cloud infrastructure team to improve documentation and defining policies for user authorization and resource creation.
- Used Jira extensively to track project progress and team deliveries.

Unfortunately, I don't have any code to share with you, as it was proprietary and deleted when I finished the job.

### Senior DevOps Engineer @ Upwave

In this project my first goal was to migrate and improve the current IaC to make multi-region, and automated, ie: created,
configured and running after a disaster recovery or a new region deployment. That was the goal and we go pretty close.
For example, I developed API tools that would connect to Opensearch and create Dashboard and Alerts after a Developer added the Json configuration to the application repository. This allowed them to created custom Dahsboards and Alerts for each new feature without any more hassle that filling up the valued in the json protype or expporting them from Opensearch to create in limited production environment or new regions.

Unfortunately, I don't have any code to share with you, as it was proprietary and deleted when I finished the job.

- Advanced IaC development using Terraform and Terraform Clould Workspaces
- Managed Kubernetes clusters.
- Deployed microservices with Kustomize.
- Configured AWS services including: EKS, Beanstalk, RDS, Glue, Firehose, EMR, CloudFront, SQS, Athena, and others.
- Developed Ansible scripts to automate provisioning of compute environments.
- Managed CI/CD pipelines for CMA BE and FE and other microservices using Octopus, Bitbucket, and JFrog.
- Managed logs with Opensearch, developed an API client to automate configuration of Indexing, Lifecycle and Dashboard amongst other things.
- Monitored Kubernetes clusters using Prometheus and Grafana.
- Increased our IaC coverage significantly by:
  - Adding an EKS cluster and VPC to Terraform and managing most accounts.
  - Deploying and configuring an OpenSearch cluster using Terraform and Python.
  - Fixing broken code in Databricks installations, which had previously been applied manually.
- Added Databricks and Kafka connectivity to different data sources.

Unfortunately, I don't have any code to share with you, as it was proprietary and deleted when I finished the job.

### DevOps Engineer @ Netlabs
- Gave talks about [Cloud Infrastructure Best Practices](https://github.com/andresr27/portfolio/tree/master/public/DevOps_Administration/Presentations)
- Built infrastructure as code using Terraform.
- Deployed VPCs, ALBs, IGWs, and integrated them with EKS clusters on AWS.
- Configured autoscaling groups and Kubernetes service-account–based roles for application scaling.
- Implemented application monitoring with Prometheus and Grafana.

### DevOps Engineer @ Upwork
- Implemented stateless Docker containers on AWS.
- Used ECS and Fargate to provide scalable, resilient services.
- Used Docker Compose for local and remote development.
- Created Bash scripts to build and push images to ECR.
- Wrote Python scripts to convert CSV inventory into Nagios-compatible CFG files.

### SRE Engineer for Antel ASVAC @ Netlabs
- Applied regular updates to the single sign-on portal for Antel applications.
- Analyzed logs and generated visual reports using the ELK stack.
- Managed networking infrastructure including load balancers, reverse proxies, and NFS.
- Participated in the migration of frontend and API components for Vera TV to a new RL3 data center.

### System Administrator for XN Brasil
- Debugged full-stack applications in production.
- Deployed a PHP/Laravel application to AWS.
- Deployed and configured Jira Service Desk.

## Developer

### Python Full Stack Developer for BioIntellisense
- Used the Pandas framework to analyze data and generate alerts.
- Optimized Data Science algorithms for deployment in GCP Cloud Functions.
- Built data pipelines using protocol buffers.
- Stored and retrieved events from Bigtable.
- Wrote integration tests using `unittest` and `pytest`.

### Product Developer for Antel NDG
- Designed a multilayer reference architecture for IaaS clients using vCloud Director.
- Managed Linux VM templates using Ansible.
- Managed web access with Apache mod_proxy, pfSense, and vShields.
- **Deployed ELK stack and Zabbix servers using Docker Swarm.**

### Full Stack Developer for Boxes
- [Replaced PyGame with Kivy for improved embedded UI performance.](https://github.com/andresr27/portfolio/tree/master/Software_Development/Device%20UI-UX)
- Redesigned Raspberry Pi "shield" circuit boards to reduce cost and build time.
- [Created an IoT broker service using Java WebSockets.](https://github.com/andresr27/portfolio/tree/master/Software_Development/Web%20Admin)
- Developed a Bootstrap/JavaScript admin console, deployed on AWS with Gradle.
- Wrote a Python client to enable M2M communication via OpenVPN.

# Education

## Courses
- 2025 Hackerrank Python Training.
- 2025 Entry-Level Security – [Cybrary](https://app.cybrary.it/)
- 2024 Introduction to Deep Q Learning – Udemy
- 2022 Terraform Associate Certification – [HashiCorp](https://developer.hashicorp.com/terraform/tutorials/certification-003/associate-study-003)
- 2022 Terraform Beginner to Advanced – Udemy
- 2020 Amazon Elastic Kubernetes Service Workshop – Online
- 2019 Use Python to Access Web Data – Online
- 2019 TEFL English Certificate – Thresholds Institute, Prague, Czech Republic
- 2018 Agile Scrum Master Introduction Course – XN, Montevideo, Uruguay
- 2017 Introduction to Tableau – Deloitte, Montevideo, Uruguay
- 2017 Azure Cloud Specialist + Open Source – Online
- 2017 AWS Solutions Architect – Online
- 2015 Introduction to Agile – IBM, Montevideo, Uruguay

## Academic Studies
- 2009–2012 Impedance Spectroscopy Specialization – Facultad de Ciencias, UDELAR, Montevideo, Uruguay  
  *Field of research: [Impedance spectroscopy over modified electrodes for specific polysaccharide detection](https://github.com/andresr27/portfolio/blob/master/Electric_Engineering/Impedance_Spectroscopy_over_metal-protein_interactions/Poster_impedancia5.pdf).*
- 2001–2008 Electrical Engineering – Facultad de Ingeniería, UDELAR, Montevideo, Uruguay  
  *[Thesis: Modbus wireless communication hardware for home and industrial automation.](https://github.com/andresr27/portfolio/blob/master/Electric_Engineering/Wireless_WPAN_devices_with_Modbus-TCP/Poster_WiDO.jpg)*
- 1999–2001 Pure and Applied Science – Vanier College, Montreal, Canada


## Public Speaking

### Virtual Infrastructure Best Practices
- Presented a multilayer reference architecture to internal teams and clients at HG (2019).

### Open Source and Big Data on Azure
- Delivered a presentation at Sinergia Tech (2017) in collaboration with Microsoft Uruguay and Netlabs.

### Study of Metal–Protein Interactions Using Impedance Spectroscopy
- Presented scientific research at CSIC and Instituto de Higiene, UDELAR (2010, 2011).

### Voice Enhancement Using Artificial Neural Networks
- Presented as part of a specialization course in neural networks, Facultad de Ciencias, UDELAR (2009).

# Languages
- Spanish – Native language
- English – Advanced
- Portuguese – Basic (speaking and listening)

# Interests
- Music
- Sports: Aikido and Surf
- Food and Nutrition
- History
