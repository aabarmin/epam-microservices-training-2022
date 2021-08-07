FROM docker.elastic.co/beats/filebeat:7.4.0

USER root

COPY filebeat.yml /usr/share/filebeat/filebeat.yml
RUN chmod go-w /usr/share/filebeat/filebeat.yml

COPY elasticsearch.yml /usr/share/filebeat/modules.d/elasticsearch.yml
RUN chmod go-w /usr/share/filebeat/modules.d/elasticsearch.yml