provider "aws" {
  region  = "eu-west-1"
  profile = "terraform-user"
}

locals {
  tags = {
    owner        = "Umang.Vadadoriya@bbd.co.za"
    createdusing = "Terraform"
  }
}

resource "aws_security_group" "ec2_SG" {
  name = "ec2_SG"

  ingress {
    from_port   = 0
    to_port     = 0
    protocol    = "-1"
    cidr_blocks = ["0.0.0.0/0"]
  }

  egress {
    from_port        = 0
    to_port          = 0
    protocol         = "-1"
    cidr_blocks      = ["0.0.0.0/0"]
    ipv6_cidr_blocks = ["::/0"]
  }

  tags = local.tags
}

resource "aws_key_pair" "deployer" {
  key_name   = "deployer-key-ec2"
  public_key = file("deployer-key-ec2")

  tags = local.tags
}

resource "aws_instance" "ec2_instance" {

  ami                    = "ami-0fc3317b37c1269d3"
  instance_type          = "t2.micro"
  key_name               = aws_key_pair.deployer.key_name
  vpc_security_group_ids = [aws_security_group.ec2_SG.id]
  user_data              = <<-EOL
  #!/bin/bash
  echo "Installing Java-21"
  sudo yum install java-21-amazon-corretto-headless -y
  echo "Installed Java-21"
  EOL
  tags                   = merge({ "Name" : "HybridHavenAPI" }, local.tags)
}

# Output the instance ID for reference
output "ec2_instance_id" {
  value = aws_instance.ec2_instance.id
}

output "ec2_key_name" {
  value = aws_instance.ec2_instance.key_name
}
