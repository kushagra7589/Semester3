# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import migrations, models


class Migration(migrations.Migration):

    dependencies = [
    ]

    operations = [
        migrations.CreateModel(
            name='Coupons',
            fields=[
                ('id', models.AutoField(serialize=False, auto_created=True, verbose_name='ID', primary_key=True)),
                ('year', models.IntegerField(default=0)),
                ('month', models.IntegerField(default=0)),
                ('breakfast', models.IntegerField(default=0)),
                ('lunch', models.IntegerField(default=0)),
                ('eveningtea', models.IntegerField(default=0)),
                ('dinner', models.IntegerField(default=0)),
            ],
        ),
        migrations.CreateModel(
            name='Student',
            fields=[
                ('id', models.AutoField(serialize=False, auto_created=True, verbose_name='ID', primary_key=True)),
                ('name', models.CharField(max_length=200)),
                ('rollno', models.IntegerField(default=0)),
            ],
        ),
        migrations.AddField(
            model_name='coupons',
            name='student',
            field=models.ForeignKey(to='myapp.Student'),
        ),
    ]
