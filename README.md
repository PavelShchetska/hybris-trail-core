hybris-trail-core
=================

Custom Extensions for the Hybris 5.0 Core Training Trail


extentions
----------

TBD


installation & setup
--------------------

TBD


general initialization
----------------------

1. Download Hybris

https://wiki.hybris.com/display/downloads/Download

This code uses hybris 5.1.0.0

Platform - minimal installation w/o commerce extensions
Suite - full hybris platforms and sample data

2. [optional] Setup Modules

https://wiki.hybris.com/display/release4/Getting+Started+with+the+hybris+Multichannel+Accelerator

Run modulegen to customize package names

Update initial data (or use acceleratorsampledata)

Model Product Catalog (yacceleratorcore items.xml)

Create impex scripts

update facades (yaccelectorfacades commercefacades)

update SOLR indexing

3. Setup developer environment

https://wiki.hybris.com/display/tr460/Trail+~+Preparation

take advantage of multipe cores (add 'build.parallel=true' to config/local.properties)


continuous integration setup
----------------------------

See https://wiki.hybris.com/display/pe/Introduction+to+Setting+Up+Continuous+Integration

TBD

http://wiki.jenkins-ci.org/display/JENKINS/Workspace+Cleanup+Plugin

add hybris/scripts dir for build scripts


todo
----

- setup build scripts?
- try symlinks for running hybris to src ctrl
- generate eclipse files etc. to keep out of src ctrl


