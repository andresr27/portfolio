## Cover Letter

Your DevOps role is the perfect intersection of my professional cloud expertise and my lifelong identity as a hardware engineer. Having followed the Flipper Zero since its inception, I admire not just the product itself but the brilliant execution of dream tool for network engineers. The opportunity to apply my skills in Kubernetes, observability, and security to support the infrastructure behind this great new device is incredibly compelling, it looks like a great tool to increase productivity.

My engineering mindset was forged through hands-on experimentation. As a teenager, I used a train variablle transformer and a DC motor from an electric track car to build a color wheel, determined to discover the exact RPM needed to achieve perceptual white—an early lesson in persistent, applied problem-solving that still drives my approach to troubleshooting and optimization today. This innate curiosity led me to root phones, flash custom firmware on Sonoffs, and design custom PCBs and is the foundation of a passion that aligns perfectly with the Flipper ethos.

I reviewed your technical requirements below, please use [this link](https://github.com/andresr27/portfolio/blob/master/cover_letter.md) if you'd like better formating.

## Application Requirements Review

- **Linux** – Advanced level: architectural knowledge, deployment, debugging 
- **K8s** – Advanced level: architecture, public and private clouds, networking (including service mesh), debugging
- **Docker** – Packaging web services and auxiliary tools
- **Observability** – Monitoring (Zabbix/Nagios, etc.), Logging (Graylog, Logstash, etc.), Metrics (Prometheus)
- **Networks** – OSI Model, Linux network stack
- **Python** – For practical tasks related to automation of deployment, testing, monitoring

### Linux:

I joined Netlabs after being a Data Center Technical Leader for IBM simply because they were a Red Hat partner and known for having the best Linux sysadmins. I went from being responsible for two data centers' operations to a junior sysadmin just to learn from the best mentors—and I did, at least for Linux.

While my recent focus has been on cloud-native environments, I maintain deep hands-on Linux expertise. I've worked with anything from iptables, SELinux, file ACLs, LVM, firewalls, user management and permissions, and file systems including Ceph, GlusterFS, and NFS. I've used Apache, Nginx, and HAProxy on Linux, pfSense, LDAP servers, and much more.

Please check [this project](https://github.com/andresr27/portfolio/blob/master/Readme.md#product-developer-for-antel-ndg) on my CV and [this experience](https://github.com/andresr27/portfolio/blob/master/Readme.md#20182019-reliability-engineer-netlabs-hg-offices-montevideo-uruguay).

### K8s and Docker:

I've deployed several types of applications to Kubernetes, including Spring Boot built with Gradle and Maven, Python application modules, and Node websites using Express and Next—I even learned about Nuxt because of this job posting.

I'm familiar with the importance of:
- Light containers for better resource allocation
- Build-Tag-Push processes and registry management, as well as using the correct image update parameters
- Proper liveness and readiness checks to improve availability
- Actuators and similar tools to publish internal metrics for better monitoring and scaling, both horizontally and vertically
- Managing virtual and physical volumes configuration to handle data retention after deployment deletion, for example
- How to deploy DaemonSets, StatefulSets, Deployments, CronJobs, etc.
- How to migrate cluster versions and loads to specific node groups
- The difference between nginx-controller from K8s and kubernetes-controller from Nginx
- How to configure Virtual Servers, Virtual Routes, APIs, Targets, Service Accounts, Secrets, ConfigMaps, etc.

### Observability:

I've used all of them. For Nagios, I configured containers images from exports from Linux instances. However, I would use Opensearch with OTEL and Data Prepper as a substitute for all of them. They look old compared to these new tools, and you get a true APM with metrics, logging, and traces for a fraction of the cost of a SaaS product. 

Most of my experience comes from building mixed-environment Grafana/Prometheus for metrics and OpenSearch/Fluent-bit for logging—it's powerful and robust, but it can be simplified.

Please check these projects for details on my experience with [Kubernetes](https://github.com/andresr27/portfolio/blob/master/Readme.md#senior-devops-engineer--upwave) and [Observability](https://github.com/andresr27/portfolio/blob/master/Readme.md#sre-engineer-for-antel-asvac--netlabs).

## Nice-to-Haves

### macOS and Windows Skills

I used macOS in my last two jobs and managed Windows servers for SCADA systems with MS SQL. I've also used Windows in other jobs, especially earlier ones. I still keep a Windows computer to test OpenVPN connections and other agents.

### Knowledge of GitHub/GitLab CI/CD

I completed [this GitHub Actions course](https://www.linkedin.com/learning/github-actions-for-ci-cd) with the LinkedIn Learning trial, resulting in [this action](https://github.com/andresr27/advanced-github-actions).

The key is to have good testing for each stage of the CI/CD peer review process. I would love to try blue/green or canary deployments someday, but no company I've worked for has gotten that far.

### Experience Configuring L2/L3 Network Equipment

As an electronic engineer, I have a solid foundation in networking models. In particular, I did my thesis building an electronic board that implemented RS-485 over FHSS (Frequency Hopping Spread Spectrum) wireless connectivity to reduce cabling in industrial automation.

I programmed Atmel microcontrollers in C/Assembler with SPI and JTAG, configuring the transceiver interruption response routines. I wrote the state machine that implemented L2/L3 communication using WPAN IEEE 802.15.4.

I've also installed or configured physical switches and routers (Cisco), F5 Load Balancer, Linux Apache and Nginx reverse proxies and load balancers, including different load balancing algorithms like cookie-based, round-robin, least_connections, IP, and others. Same for K8s port forwarding and ingress controller configuration.

## How I will meet responsibilities

### Managing Flipper Devices Infrastructure and K8s

I can't think of a more exciting task. My experience ensuring high availability for distributed systems would be directly applicable to maintaining the rock-solid backend required for device telemetry and firmware OTA updates that Flipper Zero users rely on. Check out [my experience at Boxes](https://github.com/andresr27/portfolio/tree/master?tab=readme-ov-file#20142019-technical-leader-boxes-montevideo-uruguay)—it was one of the coolest side projects I've had, and I really made a difference in the software, the hardware, and the management console, while training future engineers to take the lead.

### Improving Infrastructure Access Control Policies

For a company whose community is built on security research, robust access control is existential.

I've implemented granular, least-privilege policies in AWS and K8s that would be crucial for protecting your build environments and sensitive user data.

### Reviewing and Improving Deployment Automation Processes

This is the DevOps mindset. In my first job as a sysadmin/developer, I had to go to the office at night just to deploy a Java binary in JBoss. These days, I give them everything preconfigured and explained, so hopefully they'd only write to say thank you and that they loved the documentation.

### Expanding Existing Monitoring Systems

This is probably my best and hardest selling point. I love OpenSearch, but maybe it's too much—yet once people see it working, no one wants to go back. I also like Zabbix; we did pretty robust endpoint testing with it and loved the integration with Telegram we used for notifications and alerts.

### Building Processes for Regular Infrastructure Audits

All the companies I worked for in Uruguay were ISO 9001 compliant, and both IBM and ANTEL/HG also implemented ISO 27001. I audited roles, was audited, and was responsible for one of the security processes for the latter.

In this new age, I would suggest a digital inventory updated regularly that we can run a vulnerability analyzer on and build a report to help create an action plan. I did this for Upwave using AWS System Manager Inventory, SSM agent, and used TWIGS to build the reports.

### Incident Management

My goal is always to build systems so resilient that incidents are rare, and when they do occur, the process is so smooth it becomes a learning opportunity, not a panic. There needs to be a clear understanding of:
- Incident classification
- Acknowledged response times
  - OnCall backup list and rotation plans
- Clear escalation processes
- Right communication tools
- Clean alarm panels—no noisy alerts
- Centralized, easy-to-find documentation

## Final Note

I am confident that my unique blend of hardware-hacking passion and professional DevOps expertise aligns perfectly with the needs of Flipper Devices. I am eager to discuss how I can contribute to your team and help support the incredible Flipper ecosystem. Thank you for your time and consideration
