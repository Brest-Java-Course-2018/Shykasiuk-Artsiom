DROP TABLE IF EXISTS detective;
CREATE TABLE detective (
  detectiveid   INT          NOT NULL AUTO_INCREMENT,
  detectivename VARCHAR(255) NOT NULL,
  detectivemail VARCHAR(255) NULL,
  PRIMARY KEY (detectiveId)
);
DROP TABLE IF EXISTS investigation;
CREATE TABLE investigation (
  investigationid   INT          NOT NULL AUTO_INCREMENT,
  investigationname VARCHAR(255) NOT NULL,
  description       VARCHAR(255) NULL,
  issolved          BOOL         NOT NULL DEFAULT FALSE,
  datesolved        DATE         NULL,
  detectiveid       INT          NOT NULL,
  PRIMARY KEY (investigationId),
  CONSTRAINT investigationToDetectiveFK
  FOREIGN KEY (detectiveId)
  REFERENCES detective (detectiveId)
);